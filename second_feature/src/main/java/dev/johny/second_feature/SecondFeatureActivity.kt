package dev.johny.second_feature

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dev.johny.api_empty_feature.EmptyFeatureMediatorProvider
import dev.johny.core_network_api.ApiServiceProvider

class SecondFeatureActivity : AppCompatActivity() {
    lateinit var viewModel: SecondFeatureViewModel

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, SecondFeatureActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_feature)

        val apiService = (applicationContext as? ApiServiceProvider)?.getApiService()
        val catApiService: CatApi = apiService
            ?.provideApiService(service = CatApi::class.java)
            ?: throw IllegalStateException()
        val catApiRepository = CatApiRepository(apiService = catApiService)

        val viewModelFactory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return when(modelClass) {
                    SecondFeatureViewModel::class.java -> SecondFeatureViewModel(catApiRepository) as T
                    else -> throw IllegalStateException("Unknown ViewModel")
                }
            }
        }

        viewModel = ViewModelProvider(this, viewModelFactory)[SecondFeatureViewModel::class.java]

        val button = findViewById<Button>(R.id.goSecondToEmptyFeature)
        button.setOnClickListener {
            val mediator = (applicationContext as? EmptyFeatureMediatorProvider)
                ?.getEmptyFeatureMediator()
                ?: throw IllegalStateException()

            startActivity(mediator.getEmptyFeatureIntent(this))
        }
    }

}
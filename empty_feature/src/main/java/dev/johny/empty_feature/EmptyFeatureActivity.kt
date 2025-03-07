package dev.johny.empty_feature

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dev.johny.api_second_feature.SecondFeatureMediatorProvider
import dev.johny.core_network_api.ApiServiceProvider

class EmptyFeatureActivity : AppCompatActivity() {
    lateinit var viewModel: EmptyFeatureViewModel

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, EmptyFeatureActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty_feature)

        val apiService = (applicationContext as? ApiServiceProvider)?.getApiService()
        val catApiService: CatApi = apiService
            ?.provideApiService(service = CatApi::class.java)
            ?: throw IllegalStateException()
        val catApiRepository = CatApiRepository(apiService = catApiService)

        val viewModelFactory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return when (modelClass) {
                    EmptyFeatureViewModel::class.java -> EmptyFeatureViewModel(catApiRepository) as T
                    else -> throw IllegalArgumentException("Unknown ViewModel")
                }
            }
        }

        viewModel = ViewModelProvider(this, viewModelFactory)[EmptyFeatureViewModel::class.java]

        val button = findViewById<Button>(R.id.goEmptyToSecondFeature)
        button.setOnClickListener {
            val mediator = (applicationContext as? SecondFeatureMediatorProvider)
                ?.getSecondFeatureMediator()
                ?: throw IllegalStateException()

            startActivity(mediator.getSecondFeatureIntent(this))
        }
    }

}
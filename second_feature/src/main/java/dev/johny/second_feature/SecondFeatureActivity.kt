package dev.johny.second_feature

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import dev.johny.api_empty_feature.EmptyFeatureMediatorProvider
import dev.johny.core_network_api.ApiServiceProvider
import dev.johny.second_feature.models.CatMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
        val catMapper = CatMapper()

        val viewModelFactory = SecondFeatureViewModel
            .SecondFeatureViewModelFactory(
                catApiRepository = catApiRepository,
                catMapper = catMapper,
            )

        viewModel = ViewModelProvider(this, viewModelFactory)[SecondFeatureViewModel::class.java]

        val button = findViewById<Button>(R.id.goSecondToEmptyFeature)
        button.setOnClickListener {
            val mediator = (applicationContext as? EmptyFeatureMediatorProvider)
                ?.getEmptyFeatureMediator()
                ?: throw IllegalStateException()

            startActivity(mediator.getEmptyFeatureIntent(this))
        }

        val catButton = findViewById<Button>(R.id.catsButton)
        catButton.setOnClickListener {
            viewModel.getCats(10)
        }

        lifecycleScope.launch(Dispatchers.IO) {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.cats.collect { cats ->
                    cats.forEach { cat ->
                        Log.d("Cat log", cat.url ?: "Unknown cat")
                    }
                }
            }
        }
    }

}
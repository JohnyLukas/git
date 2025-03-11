package dev.johny.empty_feature

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
import dev.johny.api_second_feature.SecondFeatureMediatorProvider
import dev.johny.core_network_api.ApiServiceProvider
import dev.johny.empty_feature.models.CatMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
        val catMapper = CatMapper()

        val viewModelFactory = EmptyFeatureViewModel
            .EmptyFeatureViewModelFactory(
                catApiRepository = catApiRepository,
                catMapper = catMapper
            )

        viewModel = ViewModelProvider(this, viewModelFactory)[EmptyFeatureViewModel::class.java]

        val button = findViewById<Button>(R.id.goEmptyToSecondFeature)
        button.setOnClickListener {
            val mediator = (applicationContext as? SecondFeatureMediatorProvider)
                ?.getSecondFeatureMediator()
                ?: throw IllegalStateException()

            startActivity(mediator.getSecondFeatureIntent(this))
        }

        val catButton = findViewById<Button>(R.id.catButton)
        catButton.setOnClickListener {
            viewModel.getCat()
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
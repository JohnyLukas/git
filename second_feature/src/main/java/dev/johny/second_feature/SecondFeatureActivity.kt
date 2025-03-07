package dev.johny.second_feature

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import dev.johny.api_empty_feature.EmptyFeatureMediatorProvider

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
        viewModel = ViewModelProvider(this)[SecondFeatureViewModel::class.java]

        val button = findViewById<Button>(R.id.goSecondToEmptyFeature)
        button.setOnClickListener {
            val mediator = (applicationContext as? EmptyFeatureMediatorProvider)
                ?.getEmptyFeatureMediator()
                ?: throw IllegalStateException()

            startActivity(mediator.getEmptyFeatureIntent(this))
        }
    }

}
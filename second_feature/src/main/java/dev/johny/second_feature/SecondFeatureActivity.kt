package dev.johny.second_feature

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import dev.johny.api_empty_feature.EmptyFeatureMediatorProvider

class SecondFeatureActivity : AppCompatActivity() {

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, SecondFeatureActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_feature)

        val button = findViewById<Button>(R.id.goSecondToEmptyFeature)
        button.setOnClickListener {
            val mediator = (applicationContext as? EmptyFeatureMediatorProvider)
                ?.getEmptyFeatureMediator()
                ?: throw IllegalStateException()

            startActivity(mediator.getEmptyFeatureIntent(this))
        }
    }

}
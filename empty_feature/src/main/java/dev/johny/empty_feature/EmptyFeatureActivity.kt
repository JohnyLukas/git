package dev.johny.empty_feature

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import dev.johny.api_second_feature.SecondFeatureMediatorProvider

class EmptyFeatureActivity : AppCompatActivity() {

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, EmptyFeatureActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty_feature)

        val button = findViewById<Button>(R.id.goEmptyToSecondFeature)
        button.setOnClickListener {
            val mediator = (applicationContext as? SecondFeatureMediatorProvider)
                ?.getSecondFeatureMediator()
                ?: throw IllegalStateException()

            startActivity(mediator.getSecondFeatureIntent(this))
        }
    }

}
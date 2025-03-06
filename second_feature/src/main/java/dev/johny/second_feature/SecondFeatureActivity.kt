package dev.johny.second_feature

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecondFeatureActivity : AppCompatActivity() {

    companion object {
        fun getIntent(context: Context): Intent {
            return SecondFeatureMediatorImpl().getIntent(context)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_feature)

        val button = findViewById<Button>(R.id.goSecondToEmptyFeature)
        button.setOnClickListener {}
    }
}
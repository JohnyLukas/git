package dev.johny.second_feature

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import dev.johny.api_second_feature.SecondFeatureMediator

class SecondFeatureActivity : AppCompatActivity(), SecondFeatureMediator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_feature)

        val button = findViewById<Button>(R.id.goSecondToEmptyFeature)
        button.setOnClickListener {}
    }

    override fun getIntent(context: Context): Intent {
        return Intent(context, SecondFeatureActivity::class.java)
    }
}
package dev.johny.gith

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val goToEmptyFeatureButton = findViewById<Button>(R.id.goMainToEmptyFeature)
        val goToSecondFeatureButton = findViewById<Button>(R.id.goMainToSecondFeature)

        goToEmptyFeatureButton.setOnClickListener {}

        goToSecondFeatureButton.setOnClickListener {}
    }
}
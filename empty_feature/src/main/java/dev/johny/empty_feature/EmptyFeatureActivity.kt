package dev.johny.empty_feature

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class EmptyFeatureActivity : AppCompatActivity() {

    companion object {
        fun getIntent(context: Context): Intent {
            val mediator = (context.applicationContext as? EmptyFeatureApplication)?.getMediator()
            return mediator?.getIntent(context) ?: throw IllegalStateException()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty_feature)

        val button = findViewById<Button>(R.id.goEmptyToSecondFeature)
        button.setOnClickListener {}
    }

}
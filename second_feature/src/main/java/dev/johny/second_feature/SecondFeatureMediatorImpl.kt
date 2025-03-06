package dev.johny.second_feature

import android.content.Context
import android.content.Intent
import dev.johny.api_second_feature.SecondFeatureMediator

class SecondFeatureMediatorImpl : SecondFeatureMediator {
    override fun getIntent(context: Context): Intent {
        return Intent(context, SecondFeatureActivity::class.java)
    }
}
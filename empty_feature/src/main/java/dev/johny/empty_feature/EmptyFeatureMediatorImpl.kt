package dev.johny.empty_feature

import android.content.Context
import android.content.Intent
import dev.johny.api_empty_feature.EmptyFeatureMediator

class EmptyFeatureMediatorImpl : EmptyFeatureMediator {
    override fun getEmptyFeatureIntent(context: Context): Intent {
        return Intent(context, EmptyFeatureActivity::class.java)
    }
}
package dev.johny.empty_feature

import android.app.Application
import dev.johny.api_empty_feature.EmptyFeatureMediator
import dev.johny.api_empty_feature.EmptyFeatureMediatorProvider

class EmptyFeatureApplication : Application(), EmptyFeatureMediatorProvider {
    override fun getMediator(): EmptyFeatureMediator {
        return EmptyFeatureMediatorImpl()
    }

}
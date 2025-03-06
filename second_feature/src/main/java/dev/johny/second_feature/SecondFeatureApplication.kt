package dev.johny.second_feature

import android.app.Application
import dev.johny.api_second_feature.SecondFeatureMediator
import dev.johny.api_second_feature.SecondFeatureMediatorProvider

class SecondFeatureApplication : Application(), SecondFeatureMediatorProvider {
    override fun getMediator(): SecondFeatureMediator {
        return SecondFeatureMediatorImpl()
    }

}
package dev.johny.gith

import android.app.Application
import dev.johny.api_empty_feature.EmptyFeatureMediator
import dev.johny.api_empty_feature.EmptyFeatureMediatorProvider
import dev.johny.api_second_feature.SecondFeatureMediator
import dev.johny.api_second_feature.SecondFeatureMediatorProvider
import dev.johny.core_network.ApiServiceImpl
import dev.johny.core_network_api.ApiService
import dev.johny.core_network_api.ApiServiceProvider
import dev.johny.empty_feature.EmptyFeatureMediatorImpl
import dev.johny.second_feature.SecondFeatureMediatorImpl

class MyApplication : Application(), EmptyFeatureMediatorProvider, SecondFeatureMediatorProvider, ApiServiceProvider {
    override fun getEmptyFeatureMediator(): EmptyFeatureMediator {
        return EmptyFeatureMediatorImpl()
    }

    override fun getSecondFeatureMediator(): SecondFeatureMediator {
        return SecondFeatureMediatorImpl()
    }

    override fun getApiService(): ApiService {
        return ApiServiceImpl()
    }

}

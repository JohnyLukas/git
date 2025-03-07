package dev.johny.gith

import android.app.Application
import dev.johny.api_empty_feature.EmptyFeatureMediator
import dev.johny.api_empty_feature.EmptyFeatureMediatorProvider
import dev.johny.api_second_feature.SecondFeatureMediator
import dev.johny.api_second_feature.SecondFeatureMediatorProvider
import dev.johny.core_network.RetrofitProviderImpl
import dev.johny.core_network_api.RetrofitProvider
import dev.johny.empty_feature.EmptyFeatureMediatorImpl
import dev.johny.second_feature.SecondFeatureMediatorImpl
import retrofit2.Retrofit

class MyApplication : Application(), EmptyFeatureMediatorProvider, SecondFeatureMediatorProvider, RetrofitProvider {
    override fun getEmptyFeatureMediator(): EmptyFeatureMediator {
        return EmptyFeatureMediatorImpl()
    }

    override fun getSecondFeatureMediator(): SecondFeatureMediator {
        return SecondFeatureMediatorImpl()
    }

    override fun provideRetrofit(baseUrl: String): Retrofit {
        return RetrofitProviderImpl().provideRetrofit(baseUrl)
    }
}
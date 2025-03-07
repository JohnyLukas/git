package dev.johny.core_network_api

import retrofit2.Retrofit

interface RetrofitProvider {
    fun provideRetrofit() : Retrofit
}
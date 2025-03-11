package dev.johny.core_network

import dev.johny.core_network_api.ApiService

class ApiServiceImpl : ApiService {
    private val retrofit = RetrofitBuilder()

    override fun <T> provideApiService(service: Class<T>): T {
        return retrofit.createApiService(service)
    }

}
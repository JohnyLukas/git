package dev.johny.core_network

import dev.johny.core_network_api.ApiService

class ApiServiceImpl : ApiService {
    override fun <T> provideApiService(service: Class<T>): T {
        return RetrofitBuilder.createApiService(service)
    }

}
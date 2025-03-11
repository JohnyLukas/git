package dev.johny.core_network_api

interface ApiService {
    fun <T> provideApiService(service: Class<T>) : T
}
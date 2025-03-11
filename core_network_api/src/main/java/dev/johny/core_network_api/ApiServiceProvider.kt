package dev.johny.core_network_api

interface ApiServiceProvider {
    fun getApiService(): ApiService
}
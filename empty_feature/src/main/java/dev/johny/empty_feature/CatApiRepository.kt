package dev.johny.empty_feature

import dev.johny.empty_feature.models.CatResponseItem

class CatApiRepository(private val apiService: CatApi) {
    suspend fun search(): List<CatResponseItem> = apiService.searchCat()
}
package dev.johny.second_feature

import dev.johny.second_feature.models.CatResponseItem


class CatApiRepository(private val apiService: CatApi) {
    suspend fun searchCats(limit: Int): List<CatResponseItem> = apiService.searchCats(limit = limit)
}
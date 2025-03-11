package dev.johny.empty_feature

import dev.johny.empty_feature.models.CatResponseItem
import retrofit2.http.GET

interface CatApi {
    @GET("search")
    suspend fun searchCat() : List<CatResponseItem>
}
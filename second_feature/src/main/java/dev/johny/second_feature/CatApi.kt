package dev.johny.second_feature

import dev.johny.second_feature.models.CatResponseItem
import retrofit2.http.GET
import retrofit2.http.Query

interface CatApi {
    @GET("search")
    suspend fun searchCats(
        @Query("limit") limit: Int,
    ) : List<CatResponseItem>
}
package dev.johny.second_feature.models

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class CatResponseItem(
    @JsonNames("id")
    val id: String,
    @JsonNames("url")
    val url: String,
    @JsonNames("width")
    val width: Int,
    @JsonNames("height")
    val height: Int,
)

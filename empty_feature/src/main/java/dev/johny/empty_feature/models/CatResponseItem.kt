package dev.johny.empty_feature.models

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class CatResponseItem  (
    @JsonNames("id")
    val id: String? = null,
    @JsonNames("url")
    val url: String? = null,
    @JsonNames("width")
    val width: Int? = null,
    @JsonNames("height")
    val height: Int? = null,
)
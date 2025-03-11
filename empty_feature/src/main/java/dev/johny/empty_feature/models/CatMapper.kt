package dev.johny.empty_feature.models

private const val HTTPS_PREFIX = "https://"
private const val HTTP_PREFIX = "http://"

class CatMapper {
    fun replaceUnsafeUrl(cats: List<CatResponseItem>): List<CatResponseItem> {
        return cats.map { cat ->
            if (!cat.url.startsWith(HTTPS_PREFIX)) {
                cat.copy(url = cat.url.replaceFirst(HTTP_PREFIX, HTTPS_PREFIX))
            } else cat
        }
    }

}
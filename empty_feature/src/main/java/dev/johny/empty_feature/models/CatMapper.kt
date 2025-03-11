package dev.johny.empty_feature.models

class CatMapper {
    fun checkProtocolOnImageUrl(cat: CatResponseItem): CatResponseItem {
        val protectedProtocol = "https://"
        val unprotectedProtocol = "http://"
        val isUrlProtected = cat.url.startsWith(protectedProtocol)

        return cat.copy(
            url = if (isUrlProtected) cat.url
            else cat.url.replaceFirst(unprotectedProtocol, protectedProtocol)
        )
    }

}
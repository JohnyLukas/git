package dev.johny.empty_feature.models

private const val protectedProtocol = "https://"
private const val unprotectedProtocol = "http://"

class CatMapper {
    fun checkProtocolOnImageUrl(cat: CatResponseItem): CatResponseItem {
        val isUrlProtected = cat.url.startsWith(protectedProtocol)

        return if (isUrlProtected) {
            cat
        } else {
            cat.copy(url = cat.url.replaceFirst(unprotectedProtocol, protectedProtocol))
        }
    }

}
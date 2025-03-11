package dev.johny.empty_feature.models

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.scopes.BehaviorSpecGivenContainerScope
import io.kotest.core.spec.style.scopes.BehaviorSpecWhenContainerScope
import io.kotest.core.test.TestScope
import io.kotest.matchers.shouldBe

class CatMapperTest : BehaviorSpec({
    val catMapper = CatMapper()

    Given("Test cat mapper with cat unprotected url") {
        When {
            val result = catMapper.replaceUnsafeUrl(rawCatWithUnprotectedUrl)

            Then {
                result shouldBe referenceCat
            }
        }
    }

    Given("Test cat mapper with cat protected url") {
        When {
            val result = catMapper.replaceUnsafeUrl(rawCatWithProtectedUrl)

            Then {
                result shouldBe referenceCat
            }
        }
    }

    Given("Test cat mapper without cat url") {
        When {
            val result = catMapper.replaceUnsafeUrl(rawCatWithoutUrl)

            Then {
                result shouldBe referenceCat
            }
        }
    }
})

val rawCatWithUnprotectedUrl = CatResponseItem(
    id = "cat",
    url = "http://cat.cat",
    width = 1,
    height = 2
)

val rawCatWithProtectedUrl = CatResponseItem(
    id = "cat",
    url = "https://cat.cat",
    width = 1,
    height = 2
)

val rawCatWithoutUrl = CatResponseItem(
    id = "cat",
    url = "",
    width = 1,
    height = 2
)

val referenceCat = CatResponseItem(
    id = "cat",
    url = "https://cat.cat",
    width = 1,
    height = 2
)

@Suppress("FunctionName")
suspend fun BehaviorSpecGivenContainerScope.When(
    test: suspend BehaviorSpecWhenContainerScope.() -> Unit
) {
    When("call test class", test)
}


@Suppress("FunctionName")
suspend fun BehaviorSpecWhenContainerScope.Then(test: suspend TestScope.() -> Unit) {
    Then("should verify result", test)
}
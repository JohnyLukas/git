package dev.johny.empty_feature.models

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.scopes.BehaviorSpecGivenContainerScope
import io.kotest.core.spec.style.scopes.BehaviorSpecWhenContainerScope
import io.kotest.core.test.TestScope
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe

class CatMapperTest : BehaviorSpec({
    val catMapper = CatMapper()

    Given("Test replacing unsafe URL in cat mapper") {
        forAll(
            table(
                headers = headers("expected", "inputData"),
                row(referenceCat, listOf(rawCatWithUnprotectedUrl, rawCatWithProtectedUrl)),
            )
        ) { expected, inputData ->
            When {
                val result = catMapper.replaceUnsafeUrl(inputData)

                Then {
                    result shouldBe expected
                }
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
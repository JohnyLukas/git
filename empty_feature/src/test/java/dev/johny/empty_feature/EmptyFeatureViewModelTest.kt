package dev.johny.empty_feature

import dev.johny.empty_feature.models.CatMapper
import dev.johny.empty_feature.models.Then
import dev.johny.empty_feature.models.When
import dev.johny.empty_feature.models.rawCatWithProtectedUrl
import dev.johny.empty_feature.models.rawCatWithUnprotectedUrl
import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.coEvery
import io.mockk.coVerifySequence
import io.mockk.mockk

class EmptyFeatureViewModelTest : BehaviorSpec({
    val catList = listOf(rawCatWithProtectedUrl, rawCatWithUnprotectedUrl)
    val catRepository = mockk<CatApiRepository> {
        coEvery { search() } returns catList
    }
    val catMapper = mockk<CatMapper>()
    val viewModel = EmptyFeatureViewModel(catRepository, catMapper)

    Given("Test view model") {
        When {
            viewModel.getCat()

            Then {
                coVerifySequence {
                    catRepository.search()
                    catMapper.replaceUnsafeUrl(catList)
                }
            }
        }
    }
})
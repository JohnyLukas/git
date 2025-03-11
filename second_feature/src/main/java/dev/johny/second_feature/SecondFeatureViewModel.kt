package dev.johny.second_feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import dev.johny.second_feature.models.CatMapper
import dev.johny.second_feature.models.CatResponseItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SecondFeatureViewModel(
    private val catApiRepository: CatApiRepository,
    private val catMapper: CatMapper,
) : ViewModel() {
    private val _cats = MutableStateFlow<List<CatResponseItem>>(emptyList())
    val cats = _cats.asStateFlow()

    fun getCats(limit: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = catApiRepository.searchCats(limit = limit)
            _cats.value = result.map { cat ->
                catMapper.checkProtocolOnImageUrl(cat)
            }
        }
    }

    class SecondFeatureViewModelFactory(
        private val catApiRepository: CatApiRepository,
        private val catMapper: CatMapper,
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return SecondFeatureViewModel(
                catApiRepository = catApiRepository,
                catMapper = catMapper
            ) as T
        }
    }
}
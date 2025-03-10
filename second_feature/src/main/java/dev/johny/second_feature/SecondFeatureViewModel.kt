package dev.johny.second_feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import dev.johny.second_feature.models.CatResponseItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SecondFeatureViewModel(
    private val catApiRepository: CatApiRepository,
) : ViewModel() {
    private val _cats = MutableStateFlow<List<CatResponseItem>>(emptyList())
    val cats = _cats.asStateFlow()

    fun getCats(limit: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _cats.value = catApiRepository.searchCats(limit = limit)
        }
    }

    class SecondFeatureViewModelFactory(
        private val catApiRepository: CatApiRepository,
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return SecondFeatureViewModel(catApiRepository) as T
        }
    }
}
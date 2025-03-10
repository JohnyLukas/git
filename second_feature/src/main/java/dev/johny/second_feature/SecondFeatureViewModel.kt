package dev.johny.second_feature

import androidx.lifecycle.ViewModel
import dev.johny.second_feature.models.CatResponseItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class SecondFeatureViewModel(
    private val catApiRepository: CatApiRepository,
) : ViewModel(), CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.IO + Job()

    private val _cats = MutableStateFlow<List<CatResponseItem>>(emptyList())
    val cats = _cats.asStateFlow()

    fun getCats(limit: Int) {
        launch(coroutineContext) {
            _cats.value = catApiRepository.searchCats(limit = limit)
        }
    }

}
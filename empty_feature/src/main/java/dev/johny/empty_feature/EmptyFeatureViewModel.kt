package dev.johny.empty_feature

import androidx.lifecycle.ViewModel
import dev.johny.empty_feature.models.CatResponseItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class EmptyFeatureViewModel(
    private val catApiRepository: CatApiRepository,
) : ViewModel(), CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.IO + Job()

    private val _cats = MutableStateFlow<List<CatResponseItem>>(emptyList())
    val cats = _cats.asStateFlow()

    fun getCat() {
        launch(coroutineContext) {
            _cats.value = catApiRepository.search()
        }
    }

}
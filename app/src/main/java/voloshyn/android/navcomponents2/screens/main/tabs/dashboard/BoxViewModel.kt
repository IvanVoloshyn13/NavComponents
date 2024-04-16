package voloshyn.android.navcomponents2.screens.main.tabs.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import voloshyn.android.navcomponents2.model.boxes.BoxesRepository
import voloshyn.android.navcomponents2.utils.MutableLiveEvent
import voloshyn.android.navcomponents2.utils.publishEvent
import voloshyn.android.navcomponents2.utils.share

class BoxViewModel(
    private val boxId: Long,
    private val boxesRepository: BoxesRepository
) : ViewModel() {

    private val _shouldExitEvent = MutableLiveEvent<Boolean>()
    val shouldExitEvent = _shouldExitEvent.share()

    init {
        viewModelScope.launch {
            boxesRepository.getBoxes(onlyActive = true)
                .map { boxes -> boxes.firstOrNull { it.id == boxId } }
                .collect { currentBox ->
                    _shouldExitEvent.publishEvent(currentBox == null)
                }
        }
    }
}
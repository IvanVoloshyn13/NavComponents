package voloshyn.android.navcomponents2.screens.main.tabs.dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import voloshyn.android.navcomponents2.model.boxes.BoxesRepository
import voloshyn.android.navcomponents2.model.boxes.entities.Box
import voloshyn.android.navcomponents2.utils.share

class DashboardViewModel(
    private val boxesRepository: BoxesRepository
) : ViewModel() {

    private val _boxes = MutableLiveData<List<Box>>()
    val boxes = _boxes.share()

    init {
        viewModelScope.launch {
            boxesRepository.getBoxes(onlyActive = true).collect {
                _boxes.value = it
            }
        }
    }

}
package voloshyn.android.navcomponents2.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import voloshyn.android.navcomponents2.model.accounts.AccountsRepository
import voloshyn.android.navcomponents2.utils.MutableLiveEvent
import voloshyn.android.navcomponents2.utils.publishEvent
import voloshyn.android.navcomponents2.utils.share

/**
 * SplashViewModel checks whether user is signed-in or not.
 */
class SplashViewModel(
    private val accountsRepository: AccountsRepository
) : ViewModel() {

    private val _launchMainScreenEvent = MutableLiveEvent<Boolean>()
    val launchMainScreenEvent = _launchMainScreenEvent.share()

    init {
        viewModelScope.launch {
            _launchMainScreenEvent.publishEvent(accountsRepository.isSignedIn())
        }
    }
}
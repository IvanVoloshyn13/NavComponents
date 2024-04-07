package voloshyn.android.navcomponents2

import ua.cn.stu.navcomponent.tabs.model.boxes.InMemoryBoxesRepository
import voloshyn.android.navcomponents2.model.accounts.AccountsRepository
import voloshyn.android.navcomponents2.model.accounts.InMemoryAccountsRepository
import voloshyn.android.navcomponents2.model.boxes.BoxesRepository


object Repositories {
    val accountsRepository: AccountsRepository = InMemoryAccountsRepository()

    val boxesRepository: BoxesRepository = InMemoryBoxesRepository(accountsRepository)
}
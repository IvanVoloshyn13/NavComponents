package voloshyn.android.navcomponents2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import voloshyn.android.navcomponents2.model.boxes.SQLiteBoxesRepository
import voloshyn.android.navcomponents2.model.accounts.AccountsRepository
import voloshyn.android.navcomponents2.model.accounts.SQLiteAccountsRepository
import voloshyn.android.navcomponents2.model.boxes.BoxesRepository
import voloshyn.android.navcomponents2.settings.AppSettings
import voloshyn.android.navcomponents2.settings.SharedPreferencesAppSettings
import voloshyn.android.navcomponents2.sqlite.AppSQLiteHelper


object Repositories {
    private lateinit var applicationContext: Context

    // -- stuffs

    private val database: SQLiteDatabase by lazy<SQLiteDatabase> {
       AppSQLiteHelper(applicationContext).writableDatabase
    }

    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

    private val appSettings: AppSettings by lazy {
        SharedPreferencesAppSettings(applicationContext)
    }

    // --- repositories

    val accountsRepository: AccountsRepository by lazy {
        SQLiteAccountsRepository(database, appSettings, ioDispatcher)
    }

    val boxesRepository: BoxesRepository by lazy {
        SQLiteBoxesRepository(database, accountsRepository, ioDispatcher)
    }

    fun init(context: Context) {
        applicationContext = context
    }
}
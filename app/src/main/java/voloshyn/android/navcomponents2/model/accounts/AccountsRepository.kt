package voloshyn.android.navcomponents2.model.accounts

import kotlinx.coroutines.flow.Flow
import voloshyn.android.navcomponents2.model.AccountAlreadyExistsException
import voloshyn.android.navcomponents2.model.AuthException
import voloshyn.android.navcomponents2.model.EmptyFieldException
import voloshyn.android.navcomponents2.model.PasswordMismatchException
import voloshyn.android.navcomponents2.model.accounts.entities.Account
import voloshyn.android.navcomponents2.model.accounts.entities.SignUpData

/**
 * Repository with account-related actions, e.g. sign-in, sign-up, edit account etc.
 */
interface AccountsRepository {

    /**
     * Whether user is signed-in or not.
     */
    suspend fun isSignedIn(): Boolean

    /**
     * Try to sign-in with the email and password.
     * @throws [EmptyFieldException], [AuthException]
     * @throws [StorageException]
     */
    suspend fun signIn(email: String, password: String)

    /**
     * Create a new account.
     * @throws [EmptyFieldException], [PasswordMismatchException], [AccountAlreadyExistsException]
     * @throws [StorageException]
     */
    suspend fun signUp(signUpData: SignUpData)

    /**
     * Sign-out from the app.
     */
  suspend fun logout()

    /**
     * Get the account info of the current signed-in user.
     */
   suspend fun getAccount(): Flow<Account?>

    /**
     * Change the username of the current signed-in user.
     * @throws [EmptyFieldException], [AuthException]
     * @throws [StorageException]
     */
    suspend fun updateAccountUsername(newUsername: String)

}
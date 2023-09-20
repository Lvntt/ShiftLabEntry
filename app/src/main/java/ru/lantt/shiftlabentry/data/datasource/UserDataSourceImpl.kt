package ru.lantt.shiftlabentry.data.datasource

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import ru.lantt.shiftlabentry.common.Constants
import ru.lantt.shiftlabentry.domain.entity.User

class UserDataSourceImpl(context: Context) : UserDataSource {

    private val masterKeyAlias = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val sharedPreferences = EncryptedSharedPreferences.create(
        context,
        Constants.TOKEN_PREFERENCES,
        masterKeyAlias,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    override fun saveUser(user: User) {
        sharedPreferences.edit()
            .putString(Constants.USER_FIRST_NAME_KEY, user.firstName)
            .putString(Constants.USER_SECOND_NAME_KEY, user.secondName)
            .putLong(Constants.USER_DATE_OF_BIRTH_KEY, user.dateOfBirthMillis)
            .putString(Constants.USER_PASSWORD_KEY, user.password)
            .apply()
    }

    override fun getUser(): User? {
        val firstName = sharedPreferences.getString(Constants.USER_FIRST_NAME_KEY, null)
        val secondName = sharedPreferences.getString(Constants.USER_SECOND_NAME_KEY, null)
        val dateOfBirth = sharedPreferences.getLong(Constants.USER_DATE_OF_BIRTH_KEY, Constants.DATE_OF_BIRTH_ERROR_CODE)
        val password = sharedPreferences.getString(Constants.USER_PASSWORD_KEY, null)

        if (firstName != null && secondName != null && dateOfBirth != Constants.DATE_OF_BIRTH_ERROR_CODE && password != null) {
            return User(firstName, secondName, dateOfBirth, password)
        }
        return null
    }

}
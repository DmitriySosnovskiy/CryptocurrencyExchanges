package core.storage

import android.content.SharedPreferences
import androidx.core.content.edit

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 17.05.2023
 */
class PersistentStorageImpl(private val sharedPreferences: SharedPreferences) : PersistentStorage {

    override fun getString(key: String): String? {
        return sharedPreferences.getString(key, null)
    }

    override fun getString(key: String, defaultValue: String): String {
        return sharedPreferences.getString(key, null) ?: defaultValue
    }

    override fun putString(key: String, value: String?) {
        sharedPreferences.edit { putString(key, value) }
    }

    override fun getInt(key: String, defaultValue: Int): Int {
        return sharedPreferences.getInt(key, defaultValue)
    }

    override fun putInt(key: String, value: Int?) {
        sharedPreferences.edit {
            this.putInt(key, value ?: DEFAULT_INT_VALUE)
        }
    }

    private companion object {
        const val DEFAULT_INT_VALUE = 0
    }
}
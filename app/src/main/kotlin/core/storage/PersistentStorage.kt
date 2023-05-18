package core.storage

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 17.05.2023
 */
interface PersistentStorage {

    fun getString(key: String): String?

    fun getString(key: String, defaultValue: String): String

    fun putString(key: String, value: String?)

    fun getInt(key: String, defaultValue: Int): Int

    fun putInt(key: String, value: Int?)
}
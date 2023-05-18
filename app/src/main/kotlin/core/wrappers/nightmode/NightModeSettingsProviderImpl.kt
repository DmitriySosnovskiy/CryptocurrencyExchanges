package core.wrappers.nightmode

import androidx.appcompat.app.AppCompatDelegate
import core.storage.PersistentStorage

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 17.05.2023
 */
class NightModeSettingsProviderImpl(
    private val persistentStorage: PersistentStorage
) : NightModeSettingsProvider {

    private companion object {
        const val NIGHT_MODE_SETTINGS_KEY = "NIGHT_MODE_SETTINGS_KEY"
    }

    @AppCompatDelegate.NightMode
    override fun getCurrentNightModeType(): Int {
        return persistentStorage.getInt(NIGHT_MODE_SETTINGS_KEY, AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
    }

    override fun setNightModeType(
        @AppCompatDelegate.NightMode newNightModeType: Int
    ) {
        persistentStorage.putInt(NIGHT_MODE_SETTINGS_KEY, newNightModeType)
        AppCompatDelegate.setDefaultNightMode(newNightModeType)
    }
}
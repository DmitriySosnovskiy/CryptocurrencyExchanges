package core.wrappers.nightmode

import androidx.appcompat.app.AppCompatDelegate

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 17.05.2023
 */
interface NightModeSettingsProvider {
    @AppCompatDelegate.NightMode
    fun getCurrentNightModeType(): Int

    fun setNightModeType(
        @AppCompatDelegate.NightMode newNightModeType: Int
    )
}
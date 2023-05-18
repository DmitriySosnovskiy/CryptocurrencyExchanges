package app.presentation

import android.os.Build
import androidx.appcompat.app.AppCompatDelegate
import common.presentation.base.BaseViewModel
import core.wrappers.nightmode.NightModeSettingsProvider

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 18.05.2023
 */
class AppViewModel(
    private val nightModeSettingsProvider: NightModeSettingsProvider
) : BaseViewModel() {

    fun onChangeNightMode(isNightThemeChecked: Boolean) {
        nightModeSettingsProvider.setNightModeType(
            if (isNightThemeChecked) AppCompatDelegate.MODE_NIGHT_YES
            else AppCompatDelegate.MODE_NIGHT_NO
        )
    }
}
package common.utils.ext

import android.content.res.Configuration

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 18.05.2023
 */
fun Configuration.isNightModeEnabled(): Boolean {
    return uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
}
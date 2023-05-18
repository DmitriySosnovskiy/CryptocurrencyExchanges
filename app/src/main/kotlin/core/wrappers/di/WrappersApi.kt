package core.wrappers.di

import core.wrappers.resources.ResourceProvider
import core.wrappers.nightmode.NightModeSettingsProvider

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 15.05.2023
 */
interface WrappersApi {
    val resourceProvider: ResourceProvider

    val nightModeSettingsProvider: NightModeSettingsProvider
}
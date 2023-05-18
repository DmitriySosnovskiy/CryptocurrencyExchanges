package app.di.inner

import core.wrappers.nightmode.NightModeSettingsProvider
import app.presentation.AppViewModel
import common.presentation.mvi.ViewModelProviderFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 18.05.2023
 */
@Module
object AppInnerModule {

    @Provides
    @Singleton
    fun provideAppViewModelProviderFactory(
        nightModeSettingsProvider: NightModeSettingsProvider
    ): ViewModelProviderFactory<AppViewModel> {
        return ViewModelProviderFactory {
            AppViewModel(nightModeSettingsProvider = nightModeSettingsProvider)
        }
    }
}
package core.wrappers.di

import android.content.Context
import app.di.ApplicationContext
import core.storage.PersistentStorage
import core.wrappers.resources.ResourceProvider
import core.wrappers.nightmode.NightModeSettingsProvider
import core.wrappers.nightmode.NightModeSettingsProviderImpl
import core.wrappers.resources.ResourceProviderImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 15.05.2023
 */
@Module
object WrappersModule {

    @Provides
    @Singleton
    fun provideResourceProvider(@ApplicationContext context: Context): ResourceProvider {
        return ResourceProviderImpl(context)
    }

    @Provides
    @Singleton
    fun provideNightModeSettingsSupplier(
        persistentStorage: PersistentStorage
    ): NightModeSettingsProvider {
        return NightModeSettingsProviderImpl(persistentStorage = persistentStorage)
    }
}
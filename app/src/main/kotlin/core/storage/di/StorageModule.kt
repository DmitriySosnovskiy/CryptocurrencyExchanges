package core.storage.di

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import app.di.ApplicationContext
import core.storage.PersistentStorage
import core.storage.PersistentStorageImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 14.05.2023
 */
@Module
object StorageModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(
        @ApplicationContext applicationContext: Context
    ): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(applicationContext)
    }

    @Provides
    @Singleton
    fun providePersistentStorage(
        sharedPreferences: SharedPreferences
    ): PersistentStorage {
        return PersistentStorageImpl(sharedPreferences = sharedPreferences)
    }
}
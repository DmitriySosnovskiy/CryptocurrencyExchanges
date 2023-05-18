package core.wrappers.di

import android.content.Context
import app.di.ApplicationContext
import core.storage.di.StorageApi
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 15.05.2023
 */
@Component(
    modules = [WrappersModule::class],
    dependencies = [StorageApi::class]
)
@Singleton
interface WrappersComponent : WrappersApi {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @ApplicationContext applicationContext: Context,
            storageApi: StorageApi
        ): WrappersComponent
    }
}
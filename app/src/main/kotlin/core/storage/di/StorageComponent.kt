package core.storage.di

import android.content.Context
import app.di.ApplicationContext
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 15.05.2023
 */
@Component(
    modules = [StorageModule::class],
)
@Singleton
interface StorageComponent : StorageApi {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @ApplicationContext applicationContext: Context
        ): StorageComponent
    }
}
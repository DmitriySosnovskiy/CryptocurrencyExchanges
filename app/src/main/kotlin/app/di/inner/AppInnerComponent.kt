package app.di.inner

import core.wrappers.di.WrappersApi
import dagger.Component
import javax.inject.Singleton

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 18.05.2023
 */
@Component(
    dependencies = [WrappersApi::class],
    modules = [AppInnerModule::class]
)
@Singleton
interface AppInnerComponent : AppInnerApi {
    @Component.Factory
    interface Factory {
        fun create(
            wrappersApi: WrappersApi
        ): AppInnerComponent
    }
}
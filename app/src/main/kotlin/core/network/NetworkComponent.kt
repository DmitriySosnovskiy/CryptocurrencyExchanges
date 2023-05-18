package core.network

import core.converters.ConvertersApi
import dagger.Component
import javax.inject.Singleton

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 15.05.2023
 */
@Component(
    modules = [NetworkModule::class],
    dependencies = [ConvertersApi::class]
)
@Singleton
interface NetworkComponent : NetworkApi {

    @Component.Factory
    interface Factory {
        fun create(
            convertersApi: ConvertersApi
        ): NetworkComponent
    }
}
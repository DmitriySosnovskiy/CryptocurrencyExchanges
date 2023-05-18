package features.currencylist.di

import core.coroutines.CoroutinesApi
import core.network.NetworkApi
import core.wrappers.di.WrappersApi
import dagger.Component
import javax.inject.Singleton

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 15.05.2023
 */
@Component(
    dependencies = [
        CoroutinesApi::class,
        NetworkApi::class,
        WrappersApi::class
    ],
    modules = [
        CryptocurrencyListFeatureModule::class
    ]
)
@Singleton
interface CryptocurrencyListFeatureComponent : CryptocurrencyListFeatureApi {

    @Component.Factory
    interface Factory {
        fun create(
            coroutinesApi: CoroutinesApi,
            networkApi: NetworkApi,
            wrappersApi: WrappersApi
        ): CryptocurrencyListFeatureComponent
    }
}


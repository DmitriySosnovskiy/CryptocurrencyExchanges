package features.currencylist.di

import common.di.base.FeatureHolder
import common.di.base.FeaturesContainer
import core.coroutines.CoroutinesApi
import core.network.NetworkApi
import core.wrappers.di.WrappersApi

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 16.05.2023
 */
class CryptocurrencyListFeatureHolder(featuresContainer: FeaturesContainer) :
    FeatureHolder<CryptocurrencyListFeatureApi>(featuresContainer = featuresContainer) {

    override fun buildFeature(): CryptocurrencyListFeatureApi =
        DaggerCryptocurrencyListFeatureComponent.factory().create(
            coroutinesApi = getDependency(CoroutinesApi::class.java),
            networkApi = getDependency(NetworkApi::class.java),
            wrappersApi = getDependency(WrappersApi::class.java)
        )
}
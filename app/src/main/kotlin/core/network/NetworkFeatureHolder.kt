package core.network

import common.di.base.FeatureHolder
import common.di.base.FeaturesContainer
import core.converters.ConvertersApi

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 16.05.2023
 */
class NetworkFeatureHolder(featuresContainer: FeaturesContainer) :
    FeatureHolder<NetworkApi>(featuresContainer = featuresContainer) {

    override fun buildFeature(): NetworkApi = DaggerNetworkComponent.factory().create(
        convertersApi = getDependency(ConvertersApi::class.java)
    )
}
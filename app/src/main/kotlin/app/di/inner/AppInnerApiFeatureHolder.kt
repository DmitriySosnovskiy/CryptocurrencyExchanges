package app.di.inner

import common.di.base.FeatureHolder
import common.di.base.FeaturesContainer
import core.wrappers.di.WrappersApi

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 18.05.2023
 */
class AppInnerApiFeatureHolder(
    featuresContainer: FeaturesContainer
) : FeatureHolder<AppInnerApi>(
    featuresContainer = featuresContainer
) {

    override fun buildFeature(): AppInnerApi {
        return DaggerAppInnerComponent.factory().create(
            getDependency(WrappersApi::class.java)
        )
    }
}
package core.coroutines

import common.di.base.FeatureHolder
import common.di.base.FeaturesContainer

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 16.05.2023
 */
class CoroutinesFeatureHolder(featuresContainer: FeaturesContainer) :
    FeatureHolder<CoroutinesApi>(featuresContainer = featuresContainer) {

    override fun buildFeature(): CoroutinesApi = DaggerCoroutinesComponent.create()
}
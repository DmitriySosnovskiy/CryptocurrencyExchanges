package core.converters

import common.di.base.FeatureHolder
import common.di.base.FeaturesContainer

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 16.05.2023
 */
class ConvertersFeatureHolder(featuresContainer: FeaturesContainer) :
    FeatureHolder<ConvertersApi>(featuresContainer = featuresContainer) {

    override fun buildFeature(): ConvertersApi = DaggerConvertersComponent.create()
}
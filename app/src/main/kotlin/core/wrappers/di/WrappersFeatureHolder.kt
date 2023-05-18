package core.wrappers.di

import android.content.Context
import app.di.ApplicationContext
import common.di.base.FeatureHolder
import common.di.base.FeaturesContainer
import core.storage.di.StorageApi

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 16.05.2023
 */
class WrappersFeatureHolder(
    @ApplicationContext private val applicationContext: Context,
    featuresContainer: FeaturesContainer
) :
    FeatureHolder<WrappersApi>(featuresContainer = featuresContainer) {

    override fun buildFeature(): WrappersApi = DaggerWrappersComponent.factory().create(
        applicationContext = applicationContext,
        storageApi = getDependency(StorageApi::class.java)
    )
}
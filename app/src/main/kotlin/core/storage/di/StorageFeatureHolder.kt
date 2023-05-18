package core.storage.di

import android.content.Context
import app.di.ApplicationContext
import common.di.base.FeatureHolder
import common.di.base.FeaturesContainer

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 16.05.2023
 */
class StorageFeatureHolder(
    featuresContainer: FeaturesContainer,
    @ApplicationContext private val applicationContext: Context
) :
    FeatureHolder<StorageApi>(featuresContainer = featuresContainer) {

    override fun buildFeature(): StorageApi = DaggerStorageComponent.factory().create(
        applicationContext = applicationContext
    )
}
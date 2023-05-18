package app

import android.app.Application
import app.di.DaggerAppComponent
import common.di.base.FeaturesContainer
import common.di.base.FeaturesContainerImpl

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 25.04.2023
 */
class App : Application() {

    val featuresContainer: FeaturesContainer = FeaturesContainerImpl()

    override fun onCreate() {
        super.onCreate()

        featuresContainer.init(
            features = DaggerAppComponent.factory().create(applicationContext, featuresContainer).getFeatures()
        )
    }
}
package app.di

import android.content.Context
import common.di.base.FeatureHolder
import common.di.base.FeaturesContainer
import dagger.BindsInstance
import dagger.Component
import javax.inject.Qualifier
import javax.inject.Singleton

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 15.05.2023
 */
@Component(
    modules = [
        CompoundFeatureHoldersModule::class
    ],
)
@Singleton
interface AppComponent {

    fun getFeatures(): Map<Class<*>, FeatureHolder<*>>

    @Component.Factory
    interface Factory {
        fun create(
            @ApplicationContext @BindsInstance appContext: Context,
            @BindsInstance featuresContainer: FeaturesContainer
        ): AppComponent
    }
}

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationContext
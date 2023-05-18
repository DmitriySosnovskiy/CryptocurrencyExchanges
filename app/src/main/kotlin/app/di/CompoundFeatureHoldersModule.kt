package app.di

import android.content.Context
import app.di.inner.AppInnerApi
import app.di.inner.AppInnerApiFeatureHolder
import common.di.base.FeatureHolder
import common.di.base.FeaturesContainer
import core.converters.ConvertersApi
import core.converters.ConvertersFeatureHolder
import core.coroutines.CoroutinesApi
import core.coroutines.CoroutinesFeatureHolder
import core.network.NetworkApi
import core.network.NetworkFeatureHolder
import core.storage.di.StorageApi
import core.storage.di.StorageFeatureHolder
import core.wrappers.di.WrappersApi
import core.wrappers.di.WrappersFeatureHolder
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import features.currencylist.di.CryptocurrencyListFeatureApi
import features.currencylist.di.CryptocurrencyListFeatureHolder
import javax.inject.Singleton

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 16.05.2023
 */
@Module
object CompoundFeatureHoldersModule {

    @Provides
    @Singleton
    @IntoMap
    @ClassKey(ConvertersApi::class)
    fun provideConvertersFeatureHolder(
        featuresContainer: FeaturesContainer
    ): FeatureHolder<*> {
        return ConvertersFeatureHolder(featuresContainer)
    }

    @Provides
    @Singleton
    @IntoMap
    @ClassKey(CoroutinesApi::class)
    fun provideCoroutinesFeatureHolder(
        featuresContainer: FeaturesContainer
    ): FeatureHolder<*> {
        return CoroutinesFeatureHolder(featuresContainer)
    }

    @Provides
    @Singleton
    @IntoMap
    @ClassKey(NetworkApi::class)
    fun provideNetworkFeatureHolder(
        featuresContainer: FeaturesContainer
    ): FeatureHolder<*> {
        return NetworkFeatureHolder(featuresContainer)
    }

    @Provides
    @Singleton
    @IntoMap
    @ClassKey(WrappersApi::class)
    fun provideWrappersFeatureHolder(
        @ApplicationContext applicationContext: Context,
        featuresContainer: FeaturesContainer
    ): FeatureHolder<*> {
        return WrappersFeatureHolder(applicationContext, featuresContainer)
    }

    @Provides
    @Singleton
    @IntoMap
    @ClassKey(CryptocurrencyListFeatureApi::class)
    fun provideCryptocurrencyListFeatureHolder(
        featuresContainer: FeaturesContainer
    ): FeatureHolder<*> {
        return CryptocurrencyListFeatureHolder(featuresContainer)
    }

    @Provides
    @Singleton
    @IntoMap
    @ClassKey(StorageApi::class)
    fun provideStorageFeatureHolder(
        @ApplicationContext applicationContext: Context,
        featuresContainer: FeaturesContainer
    ): FeatureHolder<*> {
        return StorageFeatureHolder(featuresContainer, applicationContext)
    }

    @Provides
    @Singleton
    @IntoMap
    @ClassKey(AppInnerApi::class)
    fun provideAppInnerApiFeatureHolder(
        featuresContainer: FeaturesContainer
    ): FeatureHolder<*> {
        return AppInnerApiFeatureHolder(featuresContainer)
    }
}
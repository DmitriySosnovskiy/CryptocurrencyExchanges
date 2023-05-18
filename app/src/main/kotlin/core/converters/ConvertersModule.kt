package core.converters

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import features.currencylist.di.CryptocurrencyListFeatureJsonAdaptersModule
import java.lang.reflect.Type
import javax.inject.Singleton
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 15.05.2023
 */
@Module(
    includes = [CryptocurrencyListFeatureJsonAdaptersModule::class]
)
object ConvertersModule {
    @Provides
    @Singleton
    fun provideMoshiConverterFactory(
        converters: Set<@JvmSuppressWildcards Pair<Type, JsonAdapter<*>>>
    ): MoshiConverterFactory {
        return MoshiConverterFactory.create(Moshi.Builder().apply {
            converters.forEach {
                add(it.first, it.second)
            }
        }.build())
    }
}
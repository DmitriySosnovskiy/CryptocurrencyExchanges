package features.currencylist.di

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Types
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import features.currencylist.data.model.ExchangeRateDTO
import java.lang.reflect.Type
import javax.inject.Singleton

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 17.05.2023
 */
@Module
object CryptocurrencyListFeatureJsonAdaptersModule {

    @Provides
    @Singleton
    @IntoSet
    @JvmSuppressWildcards
    fun provideCryptocurrenciesExchangeRateResponseDTOJsonAdapter(): Pair<Type, JsonAdapter<*>> {
        return Pair(
            Types.newParameterizedType(List::class.java, ExchangeRateDTO::class.java),
            features.currencylist.data.adapter.CryptocurrenciesExchangeRateResponseDTOJsonAdapter()
        )
    }
}
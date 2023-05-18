package features.currencylist.di

import common.data.base.Converter
import common.domain.base.invoke
import common.presentation.mvi.ViewModelProviderFactory
import core.wrappers.resources.ResourceProvider
import dagger.Module
import dagger.Provides
import features.currencylist.data.converter.ExchangeRateDTOToCryptocurrencyExchangeRateConverter
import features.currencylist.data.model.ExchangeRateDTO
import features.currencylist.data.network.api.CoinGeckoCurrencyListApi
import features.currencylist.data.repository.CryptocurrencyListRepositoryImpl
import features.currencylist.domain.models.CryptocurrencyExchangeRate
import features.currencylist.domain.repository.CryptocurrencyListRepository
import features.currencylist.domain.usecase.GetCryptocurrencyListUseCase
import features.currencylist.presentation.CryptocurrencyListViewModel
import features.currencylist.presentation.recycler.CryptocurrencyListItemsFactory
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher
import retrofit2.Retrofit

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 15.05.2023
 */
@Module
object CryptocurrencyListFeatureModule {

    @Provides
    @Singleton
    fun provideCoinGeckoApi(retrofit: Retrofit): CoinGeckoCurrencyListApi {
        return retrofit.create(CoinGeckoCurrencyListApi::class.java)
    }

    @Provides
    @Singleton
    fun provideExchangeRateDTOtoDomainConverter(): Converter<ExchangeRateDTO, CryptocurrencyExchangeRate> {
        return ExchangeRateDTOToCryptocurrencyExchangeRateConverter()
    }

    @Provides
    @Singleton
    fun provideCryptocurrencyListRepository(
        coinGeckoCurrencyListApi: CoinGeckoCurrencyListApi,
        exchangeRateDTOtoDomainConverter: Converter<ExchangeRateDTO, CryptocurrencyExchangeRate>
    ): CryptocurrencyListRepository = CryptocurrencyListRepositoryImpl(
        coinGeckoCurrencyListApi = coinGeckoCurrencyListApi,
        exchangeRateDTOtoDomainConverter = exchangeRateDTOtoDomainConverter
    )

    @Provides
    @Singleton
    fun provideGetCryptocurrencyListUseCase(
        ioDispatcher: CoroutineDispatcher,
        cryptocurrencyListRepository: CryptocurrencyListRepository
    ): GetCryptocurrencyListUseCase = GetCryptocurrencyListUseCase(
        ioDispatcher = ioDispatcher,
        cryptocurrencyListRepository = cryptocurrencyListRepository
    )

    @Provides
    @Singleton
    fun provideCryptocurrencyListViewModelFactory(
        getCryptocurrencyListUseCase: GetCryptocurrencyListUseCase,
        cryptocurrencyListItemsFactory: CryptocurrencyListItemsFactory
    ): ViewModelProviderFactory<CryptocurrencyListViewModel> {
        return ViewModelProviderFactory {
            CryptocurrencyListViewModel(
                getCryptocurrencyListUseCase = getCryptocurrencyListUseCase::invoke,
                cryptocurrencyListItemsFactory
            )
        }
    }

    @Provides
    @Singleton
    fun provideCryptocurrencyListItemsFactory(
        resourceProvider: ResourceProvider,
    ): CryptocurrencyListItemsFactory = CryptocurrencyListItemsFactory(
        resourceProvider = resourceProvider,
    )
}
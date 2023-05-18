package features.currencylist.data.repository

import common.data.base.Converter
import common.utils.ext.joinWithComma
import features.currencylist.data.model.ExchangeRateDTO
import features.currencylist.data.network.api.CoinGeckoCurrencyListApi
import features.currencylist.domain.models.Cryptocurrency
import features.currencylist.domain.models.CryptocurrencyExchangeRate
import features.currencylist.domain.repository.CryptocurrencyListRepository

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 15.05.2023
 */
class CryptocurrencyListRepositoryImpl constructor(
    private val coinGeckoCurrencyListApi: CoinGeckoCurrencyListApi,
    private val exchangeRateDTOtoDomainConverter: Converter<ExchangeRateDTO, CryptocurrencyExchangeRate>
) : CryptocurrencyListRepository {

    override suspend fun getCryptocurrenciesExchangeRate(
        cryptocurrencies: List<Cryptocurrency>
    ): List<CryptocurrencyExchangeRate> {
        return coinGeckoCurrencyListApi.getCryptocurrenciesExchangeRate(
            ids = cryptocurrencies.joinWithComma { it.id },
            currencies = EXCHANGE_RATE_CURRENCIES.joinWithComma()
        ).map {
            exchangeRateDTOtoDomainConverter.convert(it)
        }
    }

    private companion object {
        val EXCHANGE_RATE_CURRENCIES = listOf("usd", "eur", "rub")
    }
}
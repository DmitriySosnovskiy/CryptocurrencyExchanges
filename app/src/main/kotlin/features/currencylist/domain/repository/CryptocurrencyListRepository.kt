package features.currencylist.domain.repository

import features.currencylist.domain.models.Cryptocurrency
import features.currencylist.domain.models.CryptocurrencyExchangeRate

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 15.05.2023
 */
interface CryptocurrencyListRepository {

    suspend fun getCryptocurrenciesExchangeRate(
        cryptocurrencies: List<Cryptocurrency>
    ): List<CryptocurrencyExchangeRate>
}
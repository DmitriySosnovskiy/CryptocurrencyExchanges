package features.currencylist.data.converter

import common.data.base.Converter
import features.currencylist.data.model.ExchangeRateDTO
import features.currencylist.domain.models.Cryptocurrency
import features.currencylist.domain.models.CryptocurrencyExchangeRate

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 17.05.2023
 */
class ExchangeRateDTOToCryptocurrencyExchangeRateConverter : Converter<ExchangeRateDTO, CryptocurrencyExchangeRate> {

    override fun convert(from: ExchangeRateDTO): CryptocurrencyExchangeRate {
        return CryptocurrencyExchangeRate(
            cryptocurrency = requireNotNull(Cryptocurrency.retrieveById(from.id)),
            priceInUsd = from.priceInUsd,
            priceInEur = from.priceInEur,
            priceInRub = from.priceInRub,
            lastUpdatedAt = from.lastUpdatedAt
        )
    }
}
package features.currencylist.presentation.recycler

import androidx.annotation.StringRes
import app.R
import common.presentation.recycler.SectionItemData
import common.utils.ext.formatAsGregorianDate
import common.utils.ext.formatAsMoney
import core.wrappers.resources.ResourceProvider
import features.currencylist.domain.models.CryptocurrencyExchangeRate
import java.math.BigDecimal
import java.util.Date

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 17.05.2023
 */
class CryptocurrencyListItemsFactory(
    private val resourceProvider: ResourceProvider,
) {

    fun create(cryptocurrencyExchangeRates: List<CryptocurrencyExchangeRate>): List<SectionItemData> =
        cryptocurrencyExchangeRates.map {
            CryptocurrencyInfoSectionItemData(
                id = it.cryptocurrency.id,
                title = resourceProvider.getString(it.cryptocurrency.nameRes),
                iconDrawableRes = it.cryptocurrency.iconRes,
                priceInRub = getPriceString(it.priceInRub, R.string.price_in_rub),
                priceInUsd = getPriceString(it.priceInUsd, R.string.price_in_usd),
                priceInEur = getPriceString(it.priceInEur, R.string.price_in_eur),
                lastUpdatedAt = resourceProvider.getString(
                    R.string.last_update, arrayOf(
                        Date(it.lastUpdatedAt).formatAsGregorianDate()
                    )
                )
            )
        }

    private fun getPriceString(price: BigDecimal, @StringRes priceStringRes: Int): String {
        return if (price < MIN_EXCHANGE_VALUE.toBigDecimal()) {
            resourceProvider.getString(priceStringRes, arrayOf(resourceProvider.getString(R.string.amount_near_zero)))
        } else {
            resourceProvider.getString(priceStringRes, arrayOf(price.formatAsMoney()))
        }
    }

    private companion object {
        const val MIN_EXCHANGE_VALUE = 0.01
    }
}
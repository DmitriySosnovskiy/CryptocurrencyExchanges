package features.currencylist.domain.models

import java.math.BigDecimal

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 16.05.2023
 */
data class CryptocurrencyExchangeRate(
    val cryptocurrency: Cryptocurrency,
    val priceInUsd: BigDecimal,
    val priceInEur: BigDecimal,
    val priceInRub: BigDecimal,
    val lastUpdatedAt: Long
)
package features.currencylist.data.model

import java.math.BigDecimal

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 16.05.2023
 */
data class ExchangeRateDTO(
    val id: String,

    val priceInUsd: BigDecimal,

    val priceInEur: BigDecimal,

    val priceInRub: BigDecimal,

    val lastUpdatedAt: Long
)
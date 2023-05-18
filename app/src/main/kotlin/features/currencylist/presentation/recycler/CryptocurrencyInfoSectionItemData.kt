package features.currencylist.presentation.recycler

import androidx.annotation.DrawableRes
import common.presentation.recycler.SectionItemData

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 16.05.2023
 */
data class CryptocurrencyInfoSectionItemData(
    val id: String,
    val title: String,
    @DrawableRes val iconDrawableRes: Int,
    val priceInUsd: String,
    val priceInEur: String,
    val priceInRub: String,
    val lastUpdatedAt: String
): SectionItemData
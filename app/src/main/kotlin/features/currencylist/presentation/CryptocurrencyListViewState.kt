package features.currencylist.presentation

import common.presentation.recycler.SectionItemData

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 26.04.2023
 */
sealed class CryptocurrencyListViewState {

    object Loading : CryptocurrencyListViewState()

    data class Content(
        val sectionItemsData: List<SectionItemData>
    ) : CryptocurrencyListViewState()

    object Error : CryptocurrencyListViewState()
}
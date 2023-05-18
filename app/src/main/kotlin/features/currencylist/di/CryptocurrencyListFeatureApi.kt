package features.currencylist.di

import common.presentation.mvi.ViewModelProviderFactory
import features.currencylist.presentation.CryptocurrencyListViewModel

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 15.05.2023
 */
interface CryptocurrencyListFeatureApi {
    val cryptocurrencyListViewModelProviderFactory: ViewModelProviderFactory<CryptocurrencyListViewModel>
}
package features.currencylist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import common.presentation.base.BaseViewModel
import features.currencylist.domain.models.CryptocurrencyExchangeRate
import features.currencylist.presentation.recycler.CryptocurrencyListItemsFactory
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 26.04.2023
 */
class CryptocurrencyListViewModel constructor(
    private val getCryptocurrencyListUseCase: suspend () -> Result<List<CryptocurrencyExchangeRate>>,
    private val cryptocurrencyListItemsFactory: CryptocurrencyListItemsFactory
) : BaseViewModel() {

    private val _state = MutableLiveData<CryptocurrencyListViewState>()
    val state: LiveData<CryptocurrencyListViewState> = _state
    private var contentState = CryptocurrencyListViewState.Content(
        sectionItemsData = emptyList()
    )
        set(value) {
            field = value
            _state.value = value
        }

    init {
        loadData()
    }

    fun loadData() {
        viewModelScope.launch {
            _state.value = CryptocurrencyListViewState.Loading
            delay(1500L)
            getCryptocurrencyListUseCase.invoke().fold(
                onSuccess = {
                    contentState = contentState.copy(sectionItemsData = cryptocurrencyListItemsFactory.create(it))
                },
                onFailure = {
                    _state.value = CryptocurrencyListViewState.Error
                }
            )
        }
    }
}
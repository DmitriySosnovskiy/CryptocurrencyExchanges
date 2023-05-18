package features.currencylist.domain.usecase

import common.domain.base.BaseUseCase
import features.currencylist.domain.models.Cryptocurrency
import features.currencylist.domain.models.CryptocurrencyExchangeRate
import features.currencylist.domain.repository.CryptocurrencyListRepository
import kotlinx.coroutines.CoroutineDispatcher

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 15.05.2023
 */
class GetCryptocurrencyListUseCase constructor(
    private val cryptocurrencyListRepository: CryptocurrencyListRepository,
    ioDispatcher: CoroutineDispatcher
) : BaseUseCase<Unit, List<CryptocurrencyExchangeRate>>(dispatcher = ioDispatcher) {

    override suspend fun execute(arg: Unit): List<CryptocurrencyExchangeRate> {
        return cryptocurrencyListRepository.getCryptocurrenciesExchangeRate(
            cryptocurrencies = Cryptocurrency.values().asList()
        )
    }
}
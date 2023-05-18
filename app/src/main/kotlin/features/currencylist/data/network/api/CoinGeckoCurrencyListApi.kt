package features.currencylist.data.network.api

import features.currencylist.data.model.ExchangeRateDTO
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 14.05.2023
 */
interface CoinGeckoCurrencyListApi {

    @GET("simple/price?include_last_updated_at=true")
    suspend fun getCryptocurrenciesExchangeRate(
        @Query("ids") ids: String,
        @Query("vs_currencies") currencies: String,
    ): List<ExchangeRateDTO>
}
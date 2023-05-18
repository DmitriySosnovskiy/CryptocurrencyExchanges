package core.network

import retrofit2.Retrofit

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 15.05.2023
 */
interface NetworkApi {
    val coinGeckoRetrofit: Retrofit
}
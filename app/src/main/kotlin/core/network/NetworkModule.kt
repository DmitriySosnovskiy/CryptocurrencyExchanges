package core.network

import app.BuildConfig
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 14.05.2023
 */
@Module
object NetworkModule {

    @Provides
    @Singleton
    fun provideCoinGeckoRetrofitInstance(
        moshiConverterFactory: MoshiConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_COIN_GECKO_API_URL)
            .addConverterFactory(moshiConverterFactory)
            .build()
    }
}
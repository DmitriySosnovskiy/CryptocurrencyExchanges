package core.converters

import javax.inject.Named
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 15.05.2023
 */
interface ConvertersApi {
    val moshiConverterFactory: MoshiConverterFactory
}
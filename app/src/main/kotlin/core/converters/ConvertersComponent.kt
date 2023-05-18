package core.converters

import dagger.Component
import javax.inject.Named
import javax.inject.Singleton
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 15.05.2023
 */
@Component(modules = [ConvertersModule::class])
@Singleton
interface ConvertersComponent: ConvertersApi
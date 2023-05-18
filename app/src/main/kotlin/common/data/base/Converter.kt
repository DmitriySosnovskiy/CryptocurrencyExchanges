package common.data.base

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 15.05.2023
 */
interface Converter<F, T> {

    fun convert(from: F): T
}
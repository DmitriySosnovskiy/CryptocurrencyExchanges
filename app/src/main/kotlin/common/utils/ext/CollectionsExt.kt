package common.utils.ext

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 17.05.2023
 */

fun <T> Iterable<T>.joinWithComma(transform: ((T) -> CharSequence)? = null): String =
    this.joinToString(separator = ",", transform = transform)
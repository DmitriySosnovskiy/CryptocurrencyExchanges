package common.utils.ext

import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 17.05.2023
 */
fun BigDecimal.formatAsMoney(): String {
    val df = DecimalFormat("#,##0.00", DecimalFormatSymbols(Locale.ROOT).apply {
        groupingSeparator = ' '
        decimalSeparator = '.'
    })

    val scaledDecimal = this.setScale(2, RoundingMode.HALF_UP)

    return df.format(scaledDecimal)
}
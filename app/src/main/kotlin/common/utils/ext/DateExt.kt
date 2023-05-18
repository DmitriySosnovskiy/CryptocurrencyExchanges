package common.utils.ext

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 17.05.2023
 */
fun Date.formatAsGregorianDate(): String {
    val formatter = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ROOT)
    return formatter.format(this)
}
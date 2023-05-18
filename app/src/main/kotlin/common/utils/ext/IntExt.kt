package common.utils.ext

import android.content.res.Resources

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 17.05.2023
 */
fun Int.dpToPx() = (this * Resources.getSystem().displayMetrics.density).toInt()

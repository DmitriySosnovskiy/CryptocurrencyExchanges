package core.wrappers.resources

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

/**
 * Проводник ресурсов, который помогает не трогать [Context] напрямую, а только транзитивно
 * дублирует некоторые методы [Context]
 */
interface ResourceProvider {

    fun getString(resId: Int): String

    fun getString(resId: Int, args: Array<Any>): String

    fun getDrawable(@DrawableRes id: Int): Drawable?

    @ColorInt
    fun getColor(@ColorRes colorRes: Int): Int
}

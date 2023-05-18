package core.wrappers.resources

import androidx.appcompat.app.AppCompatDelegate
import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import common.utils.ext.EMPTY
import common.utils.ext.EMPTY_RESOURCE
import javax.inject.Inject

class ResourceProviderImpl @Inject constructor(
    private val context: Context
) : ResourceProvider {

    private fun getThemedContext(): Context {
        val res: Resources = context.resources
        val configuration = Configuration(res.configuration)
        val filter = res.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK.inv()

        configuration.uiMode = when (AppCompatDelegate.getDefaultNightMode()) {
            AppCompatDelegate.MODE_NIGHT_NO -> Configuration.UI_MODE_NIGHT_NO or filter
            AppCompatDelegate.MODE_NIGHT_YES -> Configuration.UI_MODE_NIGHT_YES or filter
            else -> res.configuration.uiMode
        }

        return context.createConfigurationContext(configuration)
    }

    override fun getString(@StringRes resId: Int) =
        if (resId == EMPTY_RESOURCE) String.EMPTY else context.getString(resId)

    override fun getString(resId: Int, args: Array<Any>) =
        if (resId == EMPTY_RESOURCE) String.EMPTY else context.getString(resId, *args)

    override fun getDrawable(@DrawableRes id: Int): Drawable? = ContextCompat.getDrawable(getThemedContext(), id)

    override fun getColor(@ColorRes colorRes: Int) = ContextCompat.getColor(getThemedContext(), colorRes)
}

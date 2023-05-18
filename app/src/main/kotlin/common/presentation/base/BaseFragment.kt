package common.presentation.base

import android.content.Context
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import app.App
import common.di.base.FeaturesContainer

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 26.04.2023
 */
abstract class BaseFragment(@LayoutRes contentLayoutId: Int) : Fragment(contentLayoutId) {

    @CallSuper
    override fun onAttach(context: Context) {
        getDependencies((context.applicationContext as App).featuresContainer)
        super.onAttach(context)
    }

    protected open fun getDependencies(featuresContainer: FeaturesContainer) {}
}

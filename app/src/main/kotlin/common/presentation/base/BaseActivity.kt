package common.presentation.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import app.App
import common.di.base.FeaturesContainer

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 25.04.2023
 */
abstract class BaseActivity(@LayoutRes contentLayoutId: Int) : AppCompatActivity(contentLayoutId) {

    override fun onCreate(savedInstanceState: Bundle?) {
        getDependencies((applicationContext as App).featuresContainer)
        super.onCreate(savedInstanceState)
        setupActivity(savedInstanceState)
    }

    protected open fun setupActivity(savedInstanceState: Bundle?) {
    }

    protected open fun getDependencies(featuresContainer: FeaturesContainer) {
    }
}
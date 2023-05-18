package app.di.inner

import androidx.lifecycle.ViewModelProvider
import app.presentation.AppViewModel
import common.presentation.mvi.ViewModelProviderFactory

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 18.05.2023
 */
interface AppInnerApi {

    val appViewModelProviderFactory: ViewModelProviderFactory<AppViewModel>
}
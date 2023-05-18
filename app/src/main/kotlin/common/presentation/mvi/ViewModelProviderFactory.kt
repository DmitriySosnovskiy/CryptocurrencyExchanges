package common.presentation.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.util.function.Supplier

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 15.05.2023
 */
class ViewModelProviderFactory<VM : ViewModel>(private val viewModelCreator: Supplier<VM>) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModelCreator.get() as T
    }
}
package app.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.ViewModelProvider
import app.R
import app.databinding.ActivityAppBinding
import app.di.inner.AppInnerApi
import by.kirich1409.viewbindingdelegate.viewBinding
import common.di.base.FeaturesContainer
import common.presentation.base.BaseActivity
import common.utils.ext.isNightModeEnabled
import core.wrappers.di.WrappersApi
import core.wrappers.nightmode.NightModeSettingsProvider

/**
 *
 *
 * @author Dmitriy Sosnovskiy on 25.04.2023
 */
class AppActivity : BaseActivity(R.layout.activity_app) {

    private lateinit var nightModeSettingsProvider: NightModeSettingsProvider

    private lateinit var viewModel: AppViewModel

    private val binding by viewBinding(ActivityAppBinding::bind)

    override fun getDependencies(featuresContainer: FeaturesContainer) {
        nightModeSettingsProvider = featuresContainer.getFeature(WrappersApi::class.java).nightModeSettingsProvider
        viewModel = ViewModelProvider(
            this,
            featuresContainer.getFeature(AppInnerApi::class.java).appViewModelProviderFactory,
        ).get(AppViewModel::class.java)
    }

    override fun setupActivity(savedInstanceState: Bundle?) {
        setContentView(binding.root)
        setupNightModeSettings()
        setSupportActionBar(binding.toolbar)
        binding.daynightSwitch.setOnSwitchListener { _, isDayThemeChecked: Boolean ->
            viewModel.onChangeNightMode(isNightThemeChecked = isDayThemeChecked.not())
        }
    }

    private fun setupNightModeSettings() {
        val currentNightMode = nightModeSettingsProvider.getCurrentNightModeType()
        AppCompatDelegate.setDefaultNightMode(currentNightMode)
        val isNightThemeEnabled = resources.configuration.isNightModeEnabled()
        binding.daynightSwitch.setDayChecked(isNightThemeEnabled.not())
        setupSystemBarsColors(isLightTheme = isNightThemeEnabled.not())
    }

    private fun setupSystemBarsColors(isLightTheme: Boolean) {
        window.statusBarColor = getColor(R.color.white_to_black)
        window.navigationBarColor = getColor(R.color.white_to_black)
        WindowInsetsControllerCompat(window, window.decorView).let { controller ->
            controller.isAppearanceLightStatusBars = isLightTheme
            controller.isAppearanceLightNavigationBars = isLightTheme
        }
    }
}
package io.neomsoft.internetmedia.ui.screens.main

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import by.kirich1409.viewbindingdelegate.viewBinding
import io.neomsoft.internetmedia.R
import io.neomsoft.internetmedia.databinding.FragmentMainBinding
import io.neomsoft.internetmedia.ui.base.BaseFragment
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment(R.layout.fragment_main) {

    private val viewModel: MainViewModel by viewModel()
    private val binding: FragmentMainBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.inputLocationName.doOnTextChanged { text, _, _, _ ->
            viewModel.onLocationNameChanged(text.toString())
        }

        viewModel.stateFlow
            .onEach { updateUi(it) }
            .launchOnResume()
    }

    private fun updateUi(state: MainState) {
        binding.progress.isVisible = state.state == MainState.State.PROGRESS
        binding.groupForecast.isVisible = state.state == MainState.State.SUCCESS

        binding.btn.isEnabled = state.canSearchNewWeather
        binding.btn.setOnClickListener { viewModel.onBtnGetForecastClick(state.locationName) }

        state.forecast?.also {
            binding.textviewCityCode.text = it.code
            binding.textviewCityName.text = it.cityName
            binding.imageWeather.setImageResource(it.weather.iconRes)
            binding.textviewTemperature.text = it.temperature.toString()
            binding.textviewShortDescription.setText(it.weather.shortTextRes)
            binding.textviewDescription.setText(it.weather.textRes)
        }
    }
}
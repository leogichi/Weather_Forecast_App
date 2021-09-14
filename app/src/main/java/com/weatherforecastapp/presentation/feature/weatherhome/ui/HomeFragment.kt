package com.weatherforecastapp.presentation.feature.weatherhome.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.weatherforecastapp.R
import com.weatherforecastapp.databinding.FragmentHomeBinding
import com.weatherforecastapp.presentation.feature.weatherhome.WeatherViewModel
import com.weatherforecastapp.presentation.feature.weatherhome.WeatherViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    val viewModel by viewModels<WeatherViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLookUp.setOnClickListener {
            viewModel.getWeather(binding.etCityName.text.toString())
        }

        viewModel.data.observe(viewLifecycleOwner, { result ->
            when (result) {
                is WeatherViewState.Error -> Toast.makeText(
                    context,
                    "There is an error",
                    Toast.LENGTH_SHORT
                ).show()
                is WeatherViewState.Loading -> Toast.makeText(
                    context,
                    "Loading",
                    Toast.LENGTH_SHORT
                )
                    .show()
                is WeatherViewState.Success -> {
                    result.data?.let {
                        val action =
                            HomeFragmentDirections.actionHomeFragmentToWeatherFragment(it.toTypedArray())


                        requireActivity().findNavController(R.id.nav_host_fragment).navigate(action)
                        viewModel.resetData()
                    }
                }
            }

        })
    }
}
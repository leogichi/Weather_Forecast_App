package com.weatherforecastapp.presentation.feature.weatherlist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.weatherforecastapp.R
import com.weatherforecastapp.databinding.FragmentWeatherBinding
import com.weatherforecastapp.domain.models.WeatherView
import com.weatherforecastapp.presentation.feature.weatherlist.adapter.WeatherAdapter

class WeatherFragment : Fragment() {
    private lateinit var binding: FragmentWeatherBinding
    private val args by navArgs<WeatherFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        //Binding
        binding = FragmentWeatherBinding.inflate(inflater)

        //Toolbar
        requireActivity().setActionBar(binding.toolbar)
        requireActivity().actionBar?.setDisplayHomeAsUpEnabled(true)
        requireActivity().actionBar?.title = args.weatherList.firstOrNull()?.cityName ?: ""
        requireActivity().actionBar?.setHomeButtonEnabled(true)

        binding.toolbar.setNavigationOnClickListener {
            requireActivity().findNavController(R.id.nav_host_fragment).popBackStack()
        }

        setUpRecyclerView()
        return binding.root
    }

    private fun setUpRecyclerView() {
        val weatherAdapter = WeatherAdapter(::onWeatherItemClicked)
        binding.rvWeather.adapter = weatherAdapter.apply {
            submitList(args.weatherList.toList())
        }
        binding.rvWeather.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
    }

    private fun onWeatherItemClicked(weather: WeatherView) {
        val action =
            WeatherFragmentDirections.actionWeatherFragmentToWeatherDetailFragment(
                weather
            )
        findNavController().navigate(action)
    }
}
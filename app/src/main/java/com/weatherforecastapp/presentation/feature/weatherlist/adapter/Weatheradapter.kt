package com.weatherforecastapp.presentation.feature.weatherlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.weatherforecastapp.databinding.ViewholderCellWeatherBinding
import com.weatherforecastapp.domain.models.WeatherView

class WeatherAdapter(
    private val onWeatherClicked: ((WeatherView) -> Unit)
) : ListAdapter<WeatherView, WeatherAdapter.WeatherViewHolder>(WeatherDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder =
        WeatherViewHolder(
            ViewholderCellWeatherBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class WeatherViewHolder(private val itemBinding: ViewholderCellWeatherBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun onBind(weather: WeatherView) {
            itemBinding.tvWeatherElement.text = weather.weatherName
            //itemBinding.root.context.getString()
            itemBinding.tvWeatherTemp.text = String.format("%.0f", weather.temp)
            itemBinding.root.setOnClickListener {
                onWeatherClicked(weather)
            }
        }
    }
}

class WeatherDiff : DiffUtil.ItemCallback<WeatherView>() {
    override fun areItemsTheSame(oldItem: WeatherView, newItem: WeatherView): Boolean {
        return oldItem.timeStamp == newItem.timeStamp
    }

    override fun areContentsTheSame(oldItem: WeatherView, newItem: WeatherView): Boolean {
        return oldItem == newItem
    }
}
package com.gloorystudio.weatherapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.gloorystudio.weatherapp.R
import com.gloorystudio.weatherapp.databinding.ItemOtherWeatherListBinding
import com.gloorystudio.weatherapp.model.Weather
import com.squareup.picasso.Picasso


class OtherWeatherAdapter(private val weatherList: ArrayList<Weather>) :
    RecyclerView.Adapter<OtherWeatherAdapter.OtherWeatherViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OtherWeatherViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemOtherWeatherListBinding>(
            inflater,
            R.layout.item_other_weather_list,
            parent,
            false
        )
        return OtherWeatherViewHolder(view)
    }

    override fun onBindViewHolder(holder: OtherWeatherViewHolder, position: Int) =
        holder.bind(weatherList[position])

    override fun getItemCount(): Int = weatherList.size

    inner class OtherWeatherViewHolder(private var binding: ItemOtherWeatherListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(weather: Weather) {
            Picasso.get().load(weather.icon).into(binding.ivWeatherIcon)
            binding.tvDay.text = weather.day
            binding.tvTitle.text = weather.temp
        }
    }
    fun updateUser(it : List<Weather>){
        weatherList.clear()
        weatherList.addAll(it)
        notifyDataSetChanged()
    }
}
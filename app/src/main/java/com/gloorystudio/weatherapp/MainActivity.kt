package com.gloorystudio.weatherapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.gloorystudio.weatherapp.adapter.OtherWeatherAdapter
import com.gloorystudio.weatherapp.databinding.ActivityMainBinding
import com.gloorystudio.weatherapp.model.Weather

class MainActivity : AppCompatActivity() {

    private val otherWeatherAdapter = OtherWeatherAdapter(arrayListOf())
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.rvOtherWeathers.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.rvOtherWeathers.adapter = otherWeatherAdapter

        //Fake Data
        val weatherList = arrayListOf<Weather>()
        weatherList.add(Weather("PT",R.drawable.ic_mid_rain,"25°"))
        weatherList.add(Weather("S",R.drawable.ic_rainy,"26°"))
        weatherList.add(Weather("Ç",R.drawable.ic_no_cloud,"23°"))
        weatherList.add(Weather("P",R.drawable.ic_storm,"27°"))
        weatherList.add(Weather("C",R.drawable.ic_mid_rain,"35°"))
        weatherList.add(Weather("CT",R.drawable.ic_rainy,"40°"))
        weatherList.add(Weather("P",R.drawable.ic_no_cloud,"37°"))

        otherWeatherAdapter.updateUser(weatherList)
        binding.tvRefer.isSelected = true
    }
}
package com.example.composeweatherapp.data.repository

import com.example.composeweatherapp.data.mappers.toWeatherInfo
import com.example.composeweatherapp.data.remote.WeatherApi
import com.example.composeweatherapp.domain.repository.WeatherRepository
import com.example.composeweatherapp.domain.util.Resource
import com.example.composeweatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject  constructor(
    private val api: WeatherApi
): WeatherRepository {
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch (e: Exception){
            e.printStackTrace()
            Resource.Error(e.message?: "An unknown error occurred")
        }
    }
}
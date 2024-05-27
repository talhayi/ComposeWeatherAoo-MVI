package com.example.composeweatherapp.presentation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Composable
fun WeatherForecast(
    state: WeatherState,
    modifier: Modifier = Modifier
) {
    state.weatherInfo?.weatherDataPerDay?.let { weatherDataPerDay ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            // first day data
            weatherDataPerDay[0]?.let { data ->
                Text(
                    text = "Today",
                    fontSize = 20.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(16.dp))
                LazyRow(content = {
                    items(data) { weatherData ->
                        HourlyWeatherDisplay(
                            weatherData = weatherData,
                            modifier = Modifier
                                .height(100.dp)
                                .padding(horizontal = 16.dp)
                        )
                    }
                })
            }

            Spacer(modifier = Modifier.height(16.dp))

            // second day data
            weatherDataPerDay[1]?.let { data2 ->
                Text(
                    text = "Tomorrow",
                    fontSize = 20.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(16.dp))
                LazyRow(content = {
                    items(data2) { weatherData ->
                        HourlyWeatherDisplay(
                            weatherData = weatherData,
                            modifier = Modifier
                                .height(100.dp)
                                .padding(horizontal = 16.dp)
                        )
                    }
                })
            }
        }
    }
}
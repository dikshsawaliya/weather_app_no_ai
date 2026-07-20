package com.diksh.weatherapp

import android.os.Bundle
import android.widget.HorizontalScrollView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.diksh.weatherapp.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {

    val itemList = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HomeScreen("Weather App", itemList)
        }
    }
}

@Composable
fun HomeScreen(name: String, itemsList: List<String>) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp, 40.dp, 20.dp, 20.dp),
        contentAlignment = Alignment.TopCenter
    ) {

        Column() {
            TopRow(name)
            MiddleSection()
            SecondMiddleSection()
            HorizontalScroll(itemsList)
        }

    }


}


@Composable
fun TopRow(name: String) {

    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        IconButton(onClick = {}) {
            Icon(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "menu_button"
            )
        }
        Text(modifier = Modifier.padding(10.dp), text = name)

        IconButton(onClick = {}) {
            Icon(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "calendar_button"
            )
        }

    }

}


@Composable
fun MiddleSection() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 80.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "icon"
            )

            Text(text = "29 C")
            Text(text = "Expected Heavy Rain")
        }
    }

}

@Composable
fun SecondMiddleSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = "wind_speed"
                )
                Text("24 km/hr")
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = "percipitation_level"
                )
                Text("0.2 %")
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = "sunlight"
                )
                Text("8 hr")
            }
        }
    }
}

@Composable
fun HorizontalScroll(itemsList: List<String>) {

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 34.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)){

        items(itemsList){item->
            Card() {
                Text(modifier = Modifier.padding(30.dp), text = item)
            }
        }

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    val itemList = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    WeatherAppTheme {
        HomeScreen("Weather App", itemsList = itemList)
    }
}
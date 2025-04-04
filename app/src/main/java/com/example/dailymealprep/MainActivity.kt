package com.example.dailymealprep

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dailymealprep.ui.theme.DailyMealPrepTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {var meal_mname by remember {
            mutableStateOf("")
        }

            var meal_of_the_day by remember{
                mutableStateOf("")
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = "Daily Meal Prep",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Black
                )

                Divider()
                Spacer(modifier= Modifier.size(30.dp))
                Text(text = "Daily Meal")

                OutlinedTextField(
                    value = meal_mname,
                    onValueChange = { text ->
                        meal_mname=text
                    },
                    placeholder = {
                        Text(text = "Enter time of the day")
                    }
                )
                Spacer(modifier= Modifier.size(30.dp))
                Row {

                    Button(onClick = {

                        meal_of_the_day = when (meal_mname){
                            "Morning breakfast" -> "Overnight Oats"
                            "Mid-Morning snack" -> "Fruit Bowl"

                            "Afternoon lunch" -> "Hake, Chips and Green Salad"
                            "Mid-Afternoon" -> "Donut"

                            "Dinner" -> "Roast chicken with Couscous Salad"
                            "Dessert" -> "Chocolate Cake"
                            else -> "Invalid meal name"
                        }
                        
                    }) {
                        Text(text = "Search")
                    }
                    Button(onClick = {
                        meal_mname = ""
                        meal_of_the_day =""

                    }) {
                        Text(text = "Clear")
                    }
                }

                Text(text = "Your meal today for $meal_mname is")
                Text(text = meal_of_the_day)
    }
    }
}}


package com.nels.master.androidpractices

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.nels.master.androidpractices.builder.Car
import com.nels.master.androidpractices.ui.theme.AndroidPracticesTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AndroidPracticesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {


                }

                try {
                    val car1 = Car.Builder()
                        .year(1700)
                        .color("Blue")
                        .brand("Mercedez")
                        .model("M3")
                        .build2()
                }catch (ex: Exception){
                    ex.printStackTrace()
                }
            }




        }
    }
}


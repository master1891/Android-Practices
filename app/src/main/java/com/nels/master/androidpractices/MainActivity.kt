package com.nels.master.androidpractices

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.nels.master.androidpractices.abstractfactory.FactoryDevices
import com.nels.master.androidpractices.builder.Car
import com.nels.master.androidpractices.factorypattern.ProductFactory
import com.nels.master.androidpractices.prototype.Pajaro
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
                //Patron factory
                val productJabon = ProductFactory.crearProducto("jabon")
                val productEscoba = ProductFactory.crearProducto("escoba")

                productJabon?.doProduct()
                productEscoba?.doProduct()


                //Patron AbstracFactory
                val factoryIphone = FactoryDevices.doIphone("iphone15")
                val factorySam = FactoryDevices.doSamsung("s24")


                 val cardenal = Pajaro(name = "Cardenal")
                 val prototypeCardenal = cardenal.copy()


            }



        }
    }
}


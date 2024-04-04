package com.nels.master.androidpractices

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.nels.master.androidpractices.ui.theme.AndroidPracticesTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.asStateFlow

@AndroidEntryPoint
class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidPracticesTheme {
                MainScreen()
            }

        }
    }

    @Composable
    private fun MainScreen() {


        val mainViewModel = hiltViewModel<MainViewModel>()
        val mainViewModelState by mainViewModel.nameState.collectAsState()

        /*
        LaunchedEffect(Unit) {
            mainViewModel.changeName("Master")
        }
         */

        LaunchedEffect(true) {
            mainViewModel.changeName("Master")
        }


       Box(
           modifier = Modifier.fillMaxSize(),
           contentAlignment = Alignment.Center
       ) {
            Text(text = mainViewModelState)
       }
    }
}


package com.nels.master.androidpractices

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nels.master.androidpractices.presentation.MainEvent
import com.nels.master.androidpractices.presentation.MainViewModel
import com.nels.master.androidpractices.ui.theme.AndroidPracticesTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    val viewmodel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(viewmodel)
        }
    }
}

@Composable
fun MainScreen(mainViewModel: MainViewModel, modifier: Modifier = Modifier) {

    val state = mainViewModel.state
    AndroidPracticesTheme(darkTheme = state.darkMode) {
        Surface {
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                LabelledSwitch(isSwitchChecked = state.darkMode,
                    label = "Dark theme values",
                    onCheckedChange = {
                        mainViewModel.onEvent(MainEvent.SelectedDarkThemeValues(it))
                    }
                ) {
                    mainViewModel.onEvent(MainEvent.SaveDarkThemeValue(it))
                }
            }
        }
    }
}

@Composable
fun LabelledSwitch(
    modifier: Modifier = Modifier,
    isSwitchChecked: Boolean,
    label: String,
    onCheckedChange: (Boolean) -> Unit,
    saveDarkThemeValue: (Boolean) -> Unit,
) {
    Surface {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(36.dp)
                .toggleable(
                    value = isSwitchChecked,
                    onValueChange = {
                        onCheckedChange(it)
                        saveDarkThemeValue(it)
                    },
                    role = Role.Switch,
                )
                .padding(horizontal = 8.dp)
        ) {
            Text(
                text = label,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(end = 16.dp)
            )
            Switch(
                checked = isSwitchChecked,
                onCheckedChange = null,
                modifier = Modifier.align(Alignment.CenterEnd)
            )
        }
    }
}


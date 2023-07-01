package com.jooheon.kmmstreamingplayer.android.features.main
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.jooheon.kmmstreamingplayer.android.features.common.MyApplicationTheme
import com.jooheon.kmmstreamingplayer.android.features.common.extensions.collectAsStateWithLifecycle
import com.jooheon.kmmstreamingplayer.android.features.main.presentation.MainScreen
import com.jooheon.kmmstreamingplayer.android.features.main.presentation.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                val viewModel = hiltViewModel<MainViewModel>().also { it.loadData() }
                val screenState by viewModel.screenState.collectAsStateWithLifecycle()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen(
                        state = screenState,
                        onEvent = viewModel::dispatch
                    )
                }
            }
        }
    }
}
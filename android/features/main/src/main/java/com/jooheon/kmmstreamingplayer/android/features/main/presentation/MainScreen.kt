package com.jooheon.kmmstreamingplayer.android.features.main.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jooheon.kmmstreamingplayer.android.features.common.MyApplicationTheme
import com.jooheon.kmmstreamingplayer.android.features.main.model.MainScreenEvent
import com.jooheon.kmmstreamingplayer.android.features.main.model.MainScreenState
import com.jooheon.kmmstreamingplayer.presentation.TestUiComponent
import timber.log.Timber


@Composable
fun MainScreen(
    state: MainScreenState,
    onEvent: (MainScreenEvent) -> Unit
) {
    Timber.d("state: ${state}")
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TestUiComponent(
                testState = state.testState,
                onButtonClick = { onEvent(MainScreenEvent.OnButtonClicked) }
            )
        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MyApplicationTheme {
        MainScreen(
            state = MainScreenState.default,
            onEvent = {}
        )
    }
}
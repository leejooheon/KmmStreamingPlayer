package com.jooheon.kmmstreamingplayer

import androidx.compose.ui.window.ComposeUIViewController
import com.jooheon.kmmstreamingplayer.domain.entity.state.TestState
import com.jooheon.kmmstreamingplayer.presentation.TestUiComponent

fun MainViewController(
    testState: TestState,
    onButtonClicked: () -> Unit,
) = ComposeUIViewController {
    TestUiComponent(
        testState = testState,
        onButtonClick = onButtonClicked
    )
}
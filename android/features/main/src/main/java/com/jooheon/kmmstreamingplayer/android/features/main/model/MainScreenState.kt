package com.jooheon.kmmstreamingplayer.android.features.main.model

import com.jooheon.kmmstreamingplayer.domain.entity.state.TestState

data class MainScreenState(
    val testState: TestState
) {
    companion object {
        val default = MainScreenState(
            testState = TestState.default
        )
    }
}
package com.jooheon.kmmstreamingplayer.android.data.datasource

import com.jooheon.kmmstreamingplayer.domain.entity.state.TestState
import javax.inject.Inject

class TestDataSource @Inject constructor() {

    fun getTestData(): TestState {
        return TestState.default.copy(
            title = "Android title",
            count = 0,
        )
    }
}
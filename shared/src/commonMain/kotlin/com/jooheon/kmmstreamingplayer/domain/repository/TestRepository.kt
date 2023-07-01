package com.jooheon.kmmstreamingplayer.domain.repository

import com.jooheon.kmmstreamingplayer.domain.entity.state.TestState

interface TestRepository {
    fun getTestData(): TestState
}
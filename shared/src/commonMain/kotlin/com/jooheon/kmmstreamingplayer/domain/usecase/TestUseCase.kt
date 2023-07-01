package com.jooheon.kmmstreamingplayer.domain.usecase

import com.jooheon.kmmstreamingplayer.domain.entity.state.TestState
import kotlinx.coroutines.flow.Flow

interface TestUseCase {
    fun getTestData(): Flow<TestState>
}
package com.jooheon.kmmstreamingplayer.domain.usecase

import com.jooheon.kmmstreamingplayer.domain.entity.state.TestState
import com.jooheon.kmmstreamingplayer.domain.repository.TestRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TestUseCaseImpl(
    private val testRepository: TestRepository
): TestUseCase {
    override fun getTestData(): Flow<TestState> {
        return flow {
            emit(testRepository.getTestData())
        }
    }
}
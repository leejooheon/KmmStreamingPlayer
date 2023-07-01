package com.jooheon.kmmstreamingplayer.android.data.repository

import com.jooheon.kmmstreamingplayer.android.data.datasource.TestDataSource
import com.jooheon.kmmstreamingplayer.domain.entity.state.TestState
import com.jooheon.kmmstreamingplayer.domain.repository.TestRepository

class TestRepositoryImpl(
    private val testDataSource: TestDataSource
): TestRepository {
    override fun getTestData(): TestState {
        return testDataSource.getTestData()
    }
}
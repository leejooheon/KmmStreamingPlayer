package com.jooheon.kmmstreamingplayer.android.di.test

import com.jooheon.kmmstreamingplayer.android.data.datasource.TestDataSource
import com.jooheon.kmmstreamingplayer.android.data.repository.TestRepositoryImpl
import com.jooheon.kmmstreamingplayer.domain.repository.TestRepository
import com.jooheon.kmmstreamingplayer.domain.usecase.TestUseCase
import com.jooheon.kmmstreamingplayer.domain.usecase.TestUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object TestModule {

    @Provides
    fun provideTestRepository(
        testDataSource: TestDataSource
    ): TestRepository = TestRepositoryImpl(testDataSource)

    @Provides
    fun provideTestUseCase(
        testRepository: TestRepository
    ): TestUseCase = TestUseCaseImpl(testRepository)
}
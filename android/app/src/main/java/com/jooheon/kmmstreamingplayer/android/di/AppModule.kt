package com.jooheon.kmmstreamingplayer.android.di

import android.content.Context
import android.content.res.Resources
import com.jooheon.kmmstreamingplayer.android.KmmStreamingApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApplicationContext(myApplication: KmmStreamingApp): Context = myApplication.applicationContext

    @Provides
    @Singleton
    fun provideApplicationScope() = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    @Provides
    fun provideAppResources(context: Context): Resources = context.resources
}
package com.jooheon.kmmstreamingplayer.android.features.main.model

sealed class MainScreenEvent {
    object OnButtonClicked: MainScreenEvent()

    data class placeholder(val someData: Int): MainScreenEvent()
}
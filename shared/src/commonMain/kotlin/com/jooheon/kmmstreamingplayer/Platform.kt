package com.jooheon.kmmstreamingplayer

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
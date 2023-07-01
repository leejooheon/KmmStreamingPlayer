package com.jooheon.kmmstreamingplayer.domain.entity.state

data class TestState(
    val title: String,
    val count: Int
) {
    companion object {
        val default = TestState(
            title = "default title",
            count = 0,
        )
    }
}
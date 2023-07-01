package com.jooheon.kmmstreamingplayer.android.features.main.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jooheon.kmmstreamingplayer.android.features.main.model.MainScreenEvent
import com.jooheon.kmmstreamingplayer.android.features.main.model.MainScreenState
import com.jooheon.kmmstreamingplayer.domain.entity.state.TestState
import com.jooheon.kmmstreamingplayer.domain.usecase.TestUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val testUseCase: TestUseCase,
): ViewModel() {
    private val _screenState = MutableStateFlow(MainScreenState.default)
    val screenState = _screenState.asStateFlow()

    fun loadData() = viewModelScope.launch {
        testUseCase.getTestData()
            .onEach { testState ->
                _screenState.update {
                    it.copy(
                        testState = testState
                    )
                }
            }.launchIn(viewModelScope)
    }

    fun dispatch(event: MainScreenEvent) = viewModelScope.launch {
        when(event) {
            is MainScreenEvent.OnButtonClicked -> onButtonClicked()
            is MainScreenEvent.placeholder -> {}
        }
    }

    private fun onButtonClicked() = viewModelScope.launch {
        val state = _screenState.value.testState

        val count = state.count
        val newState = state.copy(
            count = count + 1
        )

        _screenState.update {
            it.copy(
                testState = newState
            )
        }
    }
}
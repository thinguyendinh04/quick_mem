package com.pwhs.quickmem.presentation.app.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

) : ViewModel() {
    private val _state = mutableStateOf(HomeUIState())
    val state: State<HomeUIState> = _state

    // Mutable SharedFlow to emit one-time actions like navigation
    private val _action = MutableSharedFlow<HomeUIAction>()
    val action = _action.asSharedFlow()

    // Function to handle UI events
    fun onEvent(event: HomeUIEvent) {
        when (event) {
            is HomeUIEvent.OpenSearch -> {

            }
            is HomeUIEvent.OpenFreeTrial -> {
            }

            HomeUIEvent.CreateFlashcard -> TODO()
            HomeUIEvent.DetailFolder -> TODO()
            HomeUIEvent.DetailSets -> TODO()
            HomeUIEvent.FindTopic -> TODO()
            HomeUIEvent.SaveFolder -> TODO()
            HomeUIEvent.SaveSets -> TODO()
            HomeUIEvent.ViewAllFolder -> TODO()
            HomeUIEvent.ViewAllSets -> TODO()
            HomeUIEvent.ViewMoreSets -> TODO()
        }
    }

    private suspend fun emitAction(action: HomeUIAction) {
        _action.emit(action)
    }

    fun updateHasData(hasData: Boolean) {
        _state.value = _state.value.copy(hasData = hasData)
    }
}
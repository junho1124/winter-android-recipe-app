package com.surivalcoding.composerecipeapp.core.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.jetbrains.annotations.MustBeInvokedByOverriders

abstract class ViewModelable<S: ViewStateable, VE: ViewEventable>(initialState: S): ViewModel(),
    Failrueable {
    private val _state: MutableStateFlow<S> = MutableStateFlow(initialState)
    val state = _state.asStateFlow()

    fun updateState(state: S) {
        _state.update { state }
    }

    // TODO: Exception을 구현 할 필요가 있음
    override fun gotFailure(failure: Exception) {
        failure.cause?.printStackTrace()
    }

    abstract fun onEvent(event: VE)

}
package com.surivalcoding.composerecipeapp.core

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

open class ViewModelable<S: ViewState>(initialState: S): ViewModel(), Failrueable {
    private val _state: MutableStateFlow<S> = MutableStateFlow(initialState)
    val state = _state.asStateFlow()

    fun updateState(state: S) {
        _state.update { state }
    }

    override fun gotFailure(failure: Exception) {
        failure.cause?.printStackTrace()
    }

}
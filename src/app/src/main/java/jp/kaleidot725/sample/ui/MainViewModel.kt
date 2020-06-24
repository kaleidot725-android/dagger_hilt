package jp.kaleidot725.sample.ui

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import jp.kaleidot725.sample.model.FooUsecase

class MainViewModel @ViewModelInject constructor(
    private val usecase: FooUsecase,
    @Assisted private val savedState: SavedStateHandle
): ViewModel() {
    fun print() {
        usecase.print("MainViewModel", "Event")
    }
}

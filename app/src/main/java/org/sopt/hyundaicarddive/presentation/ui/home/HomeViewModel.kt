package org.sopt.hyundaicarddive.presentation.ui.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import org.sopt.hyundaicarddive.domain.usecase.DummyUseCase

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dummyUseCase: DummyUseCase
) : ViewModel(){

}

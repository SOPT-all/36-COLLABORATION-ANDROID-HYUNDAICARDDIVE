package org.sopt.hyundaicarddive.presentation.ui.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.sopt.hyundaicarddive.domain.usecase.DummyUseCase
import org.sopt.hyundaicarddive.presentation.type.SortOptionType
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dummyUseCase: DummyUseCase
) : ViewModel(){
    private val _selectedOption = MutableStateFlow<Int>(0)
    val selectedOption: StateFlow<Int> = _selectedOption.asStateFlow()

    fun onOptionSelected(index: Int){
        _selectedOption.value = index
    }

    private fun mapIndexToOption(index: Int): String{
        return when(index){
            0 -> SortOptionType.RECOMMENDED.name.lowercase()
            1 -> SortOptionType.LATEST.name.lowercase()
            else -> SortOptionType.RECOMMENDED.name.lowercase()
        }
    }
}

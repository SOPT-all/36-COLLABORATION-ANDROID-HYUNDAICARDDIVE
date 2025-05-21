package org.sopt.hyundaicarddive.presentation.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.hyundaicarddive.domain.model.DetailData
import org.sopt.hyundaicarddive.domain.usecase.DetailUseCase
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val detailUseCase: DetailUseCase
) : ViewModel() {
    private val _detailData = MutableStateFlow<DetailData?>(null)
    val detailData: StateFlow<DetailData?> = _detailData.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()

    fun getDetail() {
        viewModelScope.launch {
            detailUseCase()
                .onSuccess { detailData ->
                    _detailData.value = detailData
                }
                .onFailure { errorMessage ->
                    _errorMessage.value = errorMessage.toString()
                }
        }
    }
}

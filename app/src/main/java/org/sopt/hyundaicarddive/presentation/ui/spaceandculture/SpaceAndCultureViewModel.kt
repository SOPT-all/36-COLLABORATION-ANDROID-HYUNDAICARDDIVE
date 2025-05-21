package org.sopt.hyundaicarddive.presentation.ui.spaceandculture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.hyundaicarddive.domain.model.SpaceAndCultureWhatsOnData
import org.sopt.hyundaicarddive.domain.usecase.SpaceAndCultureUseCase
import org.sopt.hyundaicarddive.presentation.type.SpaceAndCultureGridItem
import javax.inject.Inject

@HiltViewModel
class SpaceAndCultureViewModel @Inject constructor(
    private val spaceAndCultureUseCase: SpaceAndCultureUseCase
) : ViewModel() {

    private val _whatsOnList = MutableStateFlow<List<SpaceAndCultureWhatsOnData>>(emptyList())
    val whatsOnList: StateFlow<List<SpaceAndCultureWhatsOnData>> = _whatsOnList.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()

    val spaceListItems: List<SpaceAndCultureGridItem> = listOf(
        SpaceAndCultureGridItem.SPACE_DESIGNLIB,
        SpaceAndCultureGridItem.SPACE_MUSICLIB,
        SpaceAndCultureGridItem.SPACE_COOKINGLIB,
        SpaceAndCultureGridItem.SPACE_ARTLIB,
        SpaceAndCultureGridItem.SPACE_UNDERSTAGE,
        SpaceAndCultureGridItem.SPACE_VINYL,
        SpaceAndCultureGridItem.SPACE_STORAGE,
        SpaceAndCultureGridItem.SPACE_IRON,
        SpaceAndCultureGridItem.SPACE_RED11,
        SpaceAndCultureGridItem.SPACE_CARD
    )

    val cultureListItems: List<SpaceAndCultureGridItem> = listOf(
        SpaceAndCultureGridItem.CULTURE_SUPER,
        SpaceAndCultureGridItem.CULTURE_CULTURE,
        SpaceAndCultureGridItem.CULTURE_DAVINCI,
        SpaceAndCultureGridItem.CULTURE_OVER,
        SpaceAndCultureGridItem.CULTURE_FAN,
        SpaceAndCultureGridItem.CULTURE_LIMITED
    )

    fun getWhatsOnList() {
        viewModelScope.launch {
            spaceAndCultureUseCase()
                .onSuccess { whatsOnDataList ->
                    _whatsOnList.value = whatsOnDataList
                }.onFailure { errorMessage ->
                    _errorMessage.value = errorMessage.toString()
                }
        }
    }

    fun clearToastMessage() {
        _errorMessage.value = null
    }
}

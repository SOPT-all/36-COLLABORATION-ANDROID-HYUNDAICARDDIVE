package org.sopt.hyundaicarddive.presentation.ui.spaceandculture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.hyundaicarddive.domain.usecase.DummyUseCase
import org.sopt.hyundaicarddive.presentation.model.WhatsOnListModel
import org.sopt.hyundaicarddive.presentation.type.SpaceAndCultureGridItem
import javax.inject.Inject

@HiltViewModel
class SpaceAndCultureViewModel @Inject constructor(
    private val dummyUseCase: DummyUseCase,
) : ViewModel() {

    private val _whatsOnList = MutableStateFlow<List<WhatsOnListModel>>(emptyList())
    val whatsOnList: StateFlow<List<WhatsOnListModel>> = _whatsOnList.asStateFlow()

    private val _spaceList = MutableStateFlow<List<SpaceAndCultureGridItem>>(emptyList())
    val spaceList: StateFlow<List<SpaceAndCultureGridItem>> = _spaceList.asStateFlow()

    private val _cultureList = MutableStateFlow<List<SpaceAndCultureGridItem>>(emptyList())
    val cultureList: StateFlow<List<SpaceAndCultureGridItem>> = _cultureList.asStateFlow()

    private val dummyItems: List<WhatsOnListModel> = listOf(
        WhatsOnListModel(
            "05/10(토) ~ 06/29(일)",
            "현대 회화의 새로운 서사",
            "Storage 데이비드 살레 국내 최초\n회고전",
            "스토리지",
            "이태원",
            false,
            "https://picsum.photos/90/90",
        ),
        WhatsOnListModel(
            "05/23(금)",
            "손민수 Curated 25 박종해",
            "하이든, 슈베르트, 라벨 피아노 연주회",
            "스토리지",
            "이태원",
            true,
            "https://picsum.photos/90/90",
        ),
        WhatsOnListModel(
            "05/25(일)",
            "현대카드 Curated 98\nATARAYO",
            "계절을 노래하는 제이 팝 밴드",
            "언더스테이지",
            "이태원",
            true,
            "https://picsum.photos/90/90",
        )
    )

    private val spaceItems: List<SpaceAndCultureGridItem> = listOf(
        SpaceAndCultureGridItem.SPACE_DESIGNLIB,
        SpaceAndCultureGridItem.SPACE_MUSICLIB,
        SpaceAndCultureGridItem.SPACE_COOKINGLIB,
        SpaceAndCultureGridItem.SPACE_ARTLIB,
        SpaceAndCultureGridItem.SPACE_UNDERSTAGE,
        SpaceAndCultureGridItem.SPACE_VINYL,
        SpaceAndCultureGridItem.SPACE_STORAGE,
        SpaceAndCultureGridItem.SPACE_IRON,
        SpaceAndCultureGridItem.SPACE_RED11,
        SpaceAndCultureGridItem.SPACE_CARD,
    )

    private val cultureItems: List<SpaceAndCultureGridItem> = listOf(
        SpaceAndCultureGridItem.CULTURE_SUPER,
        SpaceAndCultureGridItem.CULTURE_CULTURE,
        SpaceAndCultureGridItem.CULTURE_DAVINCI,
        SpaceAndCultureGridItem.CULTURE_OVER,
        SpaceAndCultureGridItem.CULTURE_FAN,
        SpaceAndCultureGridItem.CULTURE_LIMITED,
    )

    fun getWhatsOnListItems() {
        viewModelScope.launch {
            _whatsOnList.value = dummyItems
        }
    }

    fun getSpaceListItems() {
        viewModelScope.launch {
            _spaceList.value = spaceItems
        }
    }

    fun getCultureListItems() {
        viewModelScope.launch {
            _cultureList.value = cultureItems
        }
    }
}
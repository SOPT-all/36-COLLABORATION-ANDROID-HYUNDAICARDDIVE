package org.sopt.hyundaicarddive.presentation.ui.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.sopt.hyundaicarddive.domain.usecase.DummyUseCase
import org.sopt.hyundaicarddive.presentation.model.HomeListModel
import org.sopt.hyundaicarddive.presentation.type.CategoryType
import org.sopt.hyundaicarddive.presentation.type.SortOptionType
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dummyUseCase: DummyUseCase
) : ViewModel() {
    private val _selectedOption = MutableStateFlow<Int>(0)
    val selectedOption: StateFlow<Int> = _selectedOption.asStateFlow()

    private val _selectedCategory = MutableStateFlow<Int>(0)
    val selectedCategory: StateFlow<Int> = _selectedCategory.asStateFlow()

    private val _changeListAlign = MutableStateFlow<Boolean>(false)
    val changeListAlign: StateFlow<Boolean> = _changeListAlign.asStateFlow()

    private val _homeList = MutableStateFlow<List<HomeListModel>>(emptyList())
    val homeList: StateFlow<List<HomeListModel>> = _homeList.asStateFlow()

    val dummyItems: List<HomeListModel> = listOf(
        HomeListModel(
            category = "디자인·아트",
            title = "영감을 주는 디자인",
            hashTag = "#디자인 #창의력",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP1170/ko/20250414/0643/P001768976.jpg/dims/resize/F_webp,400"
        ),
        HomeListModel(
            category = "건축·인테리어",
            title = "미니멀한 공간 활용",
            hashTag = "#건축 #인테리어",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20250507/1456/P001492081.jpg/dims/resize/F_webp,400"
        ),
        HomeListModel(
            category = "디자인·아트",
            title = "영감을 주는 디자인",
            hashTag = "#디자인 #창의력",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP1170/ko/20250414/0643/P001768976.jpg/dims/resize/F_webp,400"
        ),
        HomeListModel(
            category = "건축·인테리어",
            title = "미니멀한 공간 활용",
            hashTag = "#건축 #인테리어",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20250507/1456/P001492081.jpg/dims/resize/F_webp,400"
        ),
        HomeListModel(
            category = "디자인·아트",
            title = "영감을 주는 디자인",
            hashTag = "#디자인 #창의력",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP1170/ko/20250414/0643/P001768976.jpg/dims/resize/F_webp,400"
        ),
        HomeListModel(
            category = "건축·인테리어",
            title = "미니멀한 공간 활용",
            hashTag = "#건축 #인테리어",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20250507/1456/P001492081.jpg/dims/resize/F_webp,400"
        ),
        HomeListModel(
            category = "디자인·아트",
            title = "영감을 주는 디자인",
            hashTag = "#디자인 #창의력",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP1170/ko/20250414/0643/P001768976.jpg/dims/resize/F_webp,400"
        ),
        HomeListModel(
            category = "건축·인테리어",
            title = "미니멀한 공간 활용",
            hashTag = "#건축 #인테리어",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20250507/1456/P001492081.jpg/dims/resize/F_webp,400"
        ),
        HomeListModel(
            category = "디자인·아트",
            title = "영감을 주는 디자인",
            hashTag = "#디자인 #창의력",
            imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP1170/ko/20250414/0643/P001768976.jpg/dims/resize/F_webp,400"
        )
    )

    fun onOptionSelected(index: Int) {
        _selectedOption.value = index
    }

    private fun mapIndexToOption(index: Int): String {
        return when (index) {
            0 -> SortOptionType.RECOMMENDED.name.lowercase()
            1 -> SortOptionType.LATEST.name.lowercase()
            else -> SortOptionType.RECOMMENDED.name.lowercase()
        }
    }

    fun onCategorySelected(index: Int) {
        _selectedCategory.value = index
    }

    private fun mapIndexToCategory(index: Int): String {
        return when (index) {
            0 -> CategoryType.TOTAL.name.lowercase()
            1 -> CategoryType.DESIGN.name.lowercase()
            2 -> CategoryType.BUILDING.name.lowercase()
            3 -> CategoryType.TRIP.name.lowercase()
            4 -> CategoryType.MUSIC.name.lowercase()
            5 -> CategoryType.COOKING.name.lowercase()
            6 -> CategoryType.STYLE.name.lowercase()
            7 -> CategoryType.TECH.name.lowercase()
            8 -> CategoryType.SPECIAL.name.lowercase()
            else -> CategoryType.TOTAL.name.lowercase()
        }
    }

    fun onChangeListAlign() {
        _changeListAlign.value = !_changeListAlign.value
    }

    fun getHomeList() {
        _homeList.value = dummyItems
    }
}

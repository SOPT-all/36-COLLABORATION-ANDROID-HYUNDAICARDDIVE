package org.sopt.hyundaicarddive.presentation.ui.detail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.sopt.hyundaicarddive.presentation.model.DetailArticleModel
import org.sopt.hyundaicarddive.presentation.model.DetailModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor() : ViewModel() {
    private val _detailModel = MutableStateFlow<DetailModel?>(null)
    val detailModel: StateFlow<DetailModel?> = _detailModel.asStateFlow()

    val articleListSize = MutableStateFlow(0)

    val dummyDetailModel: DetailModel = DetailModel(
        address = "서울시 종로구 북촌로 31-18",
        operationTime = "화~토 12~21시 / 일, 공휴일 12~18시 (설, 추석 연휴 휴관)",
        articleList = listOf(
            DetailArticleModel(
                imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20250507/1456/P001492081.jpg/dims/resize/F_webp,400",
                title = "경계선을 넘나드는 사진가",
                subTitle = "4월의 디자이너, 다이안 아버스",
                date = "2025.04.14"
            ),
            DetailArticleModel(
                imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20250507/1456/P001492081.jpg/dims/resize/F_webp,400",
                title = "가장 창의적인 시대의 표상",
                subTitle = "디자인 라이브러리 전권 보유 컬렉션",
                date = "2025.03.18"
            ),
            DetailArticleModel(
                imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20250507/1456/P001492081.jpg/dims/resize/F_webp,400",
                title = "한국의 디자인 역사를 품다",
                subTitle = "월간 <디자인> 전권 보유 컬렉션 구축",
                date = "2025.05.13"
            ),
            DetailArticleModel(
                imageUrl = "https://image.tving.com/ntgs/contents/CTC/caip/CAIP0900/ko/20250507/1456/P001492081.jpg/dims/resize/F_webp,400",
                title = "초록의 물결",
                subTitle = "현대카드 라이브러리 5월의 새 책",
                date = "2025.05.06"
            )
        )
    )

    fun getDetail() {
        _detailModel.value = dummyDetailModel
        articleListSize.value = dummyDetailModel.articleList.size
    }
}

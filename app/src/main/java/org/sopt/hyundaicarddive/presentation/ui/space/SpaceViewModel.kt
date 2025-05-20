package org.sopt.hyundaicarddive.presentation.ui.space

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.sopt.hyundaicarddive.domain.usecase.DummyUseCase
import org.sopt.hyundaicarddive.presentation.model.SpaceModel
import org.sopt.hyundaicarddive.presentation.model.SpaceReviewModel
import javax.inject.Inject

@HiltViewModel
class SpaceViewModel @Inject constructor(
    private val dummyUseCase: DummyUseCase
) : ViewModel() {

    private val _reviewList = MutableStateFlow<List<SpaceReviewModel>>(emptyList())
    val reviewList: StateFlow<List<SpaceReviewModel>> = _reviewList.asStateFlow()

    private val _spaceModel = MutableStateFlow<SpaceModel?>(null)
    val spaceModel: StateFlow<SpaceModel?> = _spaceModel.asStateFlow()

    fun toggleLike(index: Int) {
        _reviewList.update { list ->
            list.mapIndexed { i, item ->
                if (i == index) {
                    val currentLike = !item.isLiked

                    item.copy(
                        isLiked = currentLike,
                        likeCount = item.likeCount + if (currentLike) 1 else -1
                    )
                } else {
                    item
                }
            }
        }
    }

    val dummySpaceModel = SpaceModel(
        bannerUrl = "https://picsum.photos/360/266",
        introduction = "현대카드 디자인 라이브러리는 근대 디자인 정신이 태동한 지점인 바우하우스 이후의 디자인," + " 건축, 현대 미술에 관한 1만 9천여 권의 전문서적을 엄선하여 선보인다. 소량 인쇄했거나," + " 절판된 희귀 도서를 포함해 글로벌 북 큐레이터가 선정한 북 컬렉션과 디자인에 특화된 도서 카테고리에서 디자인 라이브러리의 전문성과 객관성을 발견할 수 있다.\n\n가회동에서 위치한 전통과 현대의 조화로 재해석해 리노베이션 한 라이브러리 공간에서는 다채로운 경험을 선사한다." + " \n\n바쁜 도시의 급한 발걸음을 잊고 몰입의 시간을 통해 지적인 영감을 얻을 수 있는 공간, 현대카드 디자인 라이브러리이다.",
        address = "서울시 종로구 북촌로 31-18",
        telephone = "02-3700-2700",
        email = "designlibrary@hcs.com"
    )

    fun getSpace() {
        _spaceModel.value = dummySpaceModel
    }

    fun getReviewListItem() {
        _reviewList.value = listOf(
            SpaceReviewModel(
                imgUrl = "https://picsum.photos/292/200",
                reviewer = "Clare",
                likeCount = 0
            ),
            SpaceReviewModel(
                imgUrl = "https://picsum.photos/292/200",
                reviewer = "MJ",
                likeCount = 0
            ),
            SpaceReviewModel(
                imgUrl = "https://picsum.photos/292/200",
                reviewer = "Chloe",
                likeCount = 0
            ),
            SpaceReviewModel(
                imgUrl = "https://picsum.photos/292/200",
                reviewer = "하늘",
                likeCount = 0
            ),
            SpaceReviewModel(
                imgUrl = "https://picsum.photos/292/200",
                reviewer = "Jay",
                likeCount = 0
            )
        )
    }
}

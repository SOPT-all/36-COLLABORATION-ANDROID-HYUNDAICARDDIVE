package org.sopt.hyundaicarddive.presentation.ui.space

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.sopt.hyundaicarddive.domain.usecase.DummyUseCase
import org.sopt.hyundaicarddive.presentation.model.SpaceReviewModel
import javax.inject.Inject

@HiltViewModel
class SpaceViewModel @Inject constructor(
    private val dummyUseCase: DummyUseCase
) : ViewModel() {

    private val _reviewList = MutableStateFlow<List<SpaceReviewModel>>(emptyList())
    val reviewList: StateFlow<List<SpaceReviewModel>> = _reviewList.asStateFlow()

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

    fun getReviewListItem() {
        _reviewList.value = listOf(
            SpaceReviewModel(
                imgUrl = "https://picsum.photos/312/214",
                reviewer = "Clare",
                likeCount = 0
            ),
            SpaceReviewModel(
                imgUrl = "https://picsum.photos/312/214",
                reviewer = "MJ",
                likeCount = 0
            ),
            SpaceReviewModel(
                imgUrl = "https://picsum.photos/312/214",
                reviewer = "Chloe",
                likeCount = 0
            ),
            SpaceReviewModel(
                imgUrl = "https://picsum.photos/312/214",
                reviewer = "하늘",
                likeCount = 0
            ),
            SpaceReviewModel(
                imgUrl = "https://picsum.photos/312/214",
                reviewer = "Jay",
                likeCount = 0
            ),
        )
    }
}

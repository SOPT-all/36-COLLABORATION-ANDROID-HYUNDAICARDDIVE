package org.sopt.hyundaicarddive.presentation.ui.space

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.hyundaicarddive.domain.usecase.SpaceUseCase
import org.sopt.hyundaicarddive.presentation.model.SpaceModel
import org.sopt.hyundaicarddive.presentation.model.SpaceReviewModel
import javax.inject.Inject

@HiltViewModel
class SpaceViewModel @Inject constructor(
    private val spaceUseCase: SpaceUseCase
) : ViewModel() {

    private val _reviewList = MutableStateFlow<List<SpaceReviewModel>>(emptyList())
    val reviewList: StateFlow<List<SpaceReviewModel>> = _reviewList.asStateFlow()

    private val _spaceModel = MutableStateFlow<SpaceModel?>(null)
    val spaceModel: StateFlow<SpaceModel?> = _spaceModel.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()

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

    fun getSpace() {
        viewModelScope.launch {
            spaceUseCase()
                .onSuccess { spaceData ->
                    _spaceModel.value = SpaceModel(
                        bannerUrl = spaceData.bannerUrl,
                        introduction = spaceData.introduction,
                        address = spaceData.address,
                        telephone = spaceData.telephone,
                        email = spaceData.email
                    )
                    _reviewList.value = spaceData.reviewList.map { review ->
                        SpaceReviewModel(
                            imgUrl = review.imageUrl,
                            reviewer = review.reviewer,
                            likeCount = review.likeCount
                        )
                    }
                }
                .onFailure {
                    _errorMessage.value = errorMessage.toString()
                }
        }
    }

    fun clearToastMessage() {
        _errorMessage.value = null
    }
}

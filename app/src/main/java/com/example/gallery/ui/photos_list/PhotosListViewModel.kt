package com.example.gallery.ui.photos_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gallery.repository.PhotoRepository
import com.example.gallery.ui.model.PhotoItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class PhotosViewState(
    val photos: List<PhotoItem>? = emptyList(),
    val isLoading: Boolean = true,
)

@HiltViewModel
class PhotosListViewModel @Inject constructor(
    private val photoRepository: PhotoRepository
) : ViewModel() {

    val photosViewState: MutableStateFlow<PhotosViewState> =
        MutableStateFlow(PhotosViewState())

    init {
        viewModelScope.launch {
            val photos = photoRepository.getPhotos()
            photosViewState.value = PhotosViewState(
                photos,
                false
            )
        }
    }
}
package com.example.gallery.ui.photos_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.example.gallery.repository.PhotoRepository
import com.example.gallery.repository.api.pagination.PhotoPagingSource
import com.example.gallery.ui.model.PhotoItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class PhotosViewState(
    val photos: PagingData<PhotoItem> = PagingData.empty(),
    val isLoading: Boolean = true,
)

@HiltViewModel
class PhotosListViewModel @Inject constructor(
    private val photoRepository: PhotoRepository
) : ViewModel() {


    private val _photosViewState: MutableStateFlow<PhotosViewState> =
        MutableStateFlow(PhotosViewState())
    val photosViewState: StateFlow<PhotosViewState> = _photosViewState


    init {
        viewModelScope.launch {
            photoRepository.getPhotos().cachedIn(viewModelScope).collect {
                _photosViewState.value = PhotosViewState(
                    it, false
                )
            }
        }
    }
}
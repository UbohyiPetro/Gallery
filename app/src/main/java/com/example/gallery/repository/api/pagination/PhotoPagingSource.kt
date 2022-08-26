package com.example.gallery.repository.api.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.gallery.repository.api.PhotosApi
import com.example.gallery.repository.api.model.toPhotoItem
import com.example.gallery.ui.model.PhotoItem
import retrofit2.HttpException
import java.io.IOException
import java.lang.NullPointerException

private const val PHOTO_STARTING_PAGE = 1

class PhotoPagingSource(
    private val photosApi: PhotosApi
) : PagingSource<Int, PhotoItem>() {

    override fun getRefreshKey(state: PagingState<Int, PhotoItem>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PhotoItem> {
        val position = params.key ?: PHOTO_STARTING_PAGE
        return try {
            val response = photosApi.getPhotos(position, params.loadSize)
            val photos = response.body() ?: return LoadResult.Error(NullPointerException())
            LoadResult.Page(
                data = photos.map { it.toPhotoItem() },
                prevKey = if (position == PHOTO_STARTING_PAGE) null else position - 1,
                nextKey = if (photos.isEmpty()) null else position + 1
            )
        } catch (ex: IOException) {
            return LoadResult.Error(ex)
        } catch (ex: HttpException) {
            return LoadResult.Error(ex)
        }
    }
}
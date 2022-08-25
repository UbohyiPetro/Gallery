package com.example.gallery.repository.api

import com.example.gallery.repository.api.model.PhotoResponseItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PhotosApi {

    @GET("photos")
    suspend fun getPhotos(
        @Query("page") page: Int,
        @Query("client_id") clientId: String = "ab3411e4ac868c2646c0ed488dfd919ef612b04c264f3374c97fff98ed253dc9"
    ): Response<List<PhotoResponseItem>>
}
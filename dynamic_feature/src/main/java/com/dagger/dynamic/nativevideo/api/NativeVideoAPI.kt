package com.dagger.dynamic.nativevideo.api

import com.dagger.dynamic.nativevideo.model.NativeVideoData
import io.reactivex.Single
import retrofit2.http.GET

interface NativeVideoAPI {

    @GET(GET_RELATED_VIDEOS)
    fun getNativeVideos(): Single<List<NativeVideoData>>

    private companion object {
        const val GET_RELATED_VIDEOS = "/v2/{language}/items/"
    }
}
package com.example.testtimetonic


import retrofit2.http.POST
import retrofit2.http.Query

interface PostApiService {
  @POST("live/api.php")
  suspend fun getUserPost(
    @Query("login") login: String,
    @Query("req") req: String,
    @Query("pwd") pwd: String,
    @Query("appkey") appkey: String
  ): ApiResponse
}

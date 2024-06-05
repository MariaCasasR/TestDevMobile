package com.example.testtimetonic


import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface PostApiService {
  @POST("live/api.php")
  @FormUrlEncoded
  suspend fun getUserPost(
    @Field("req") req: String,
    @Field("login") login: String,
    @Field("pwd") pwd: String,
    @Field("appkey") appkey: String
  ): ApiResponse
}

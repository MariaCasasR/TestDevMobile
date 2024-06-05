package com.example.testtimetonic

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("status")
    val status: String,
    @SerializedName("oauthkey")
    val oauthkey: String?,
    @SerializedName("error")
    val error: String?
)
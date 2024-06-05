package com.example.testtimetonic

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    val status: String,
    val oauthkey: String?,
    val error: String?,
    val id: String?
)
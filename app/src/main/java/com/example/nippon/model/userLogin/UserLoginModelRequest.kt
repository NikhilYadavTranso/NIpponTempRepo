package com.example.nippon.model.userLogin

import com.google.gson.annotations.SerializedName

data class UserLoginModelRequest(
    @SerializedName("user_email") val userEmail: String?,
    @SerializedName("user_password") val userPassword: String?,
)




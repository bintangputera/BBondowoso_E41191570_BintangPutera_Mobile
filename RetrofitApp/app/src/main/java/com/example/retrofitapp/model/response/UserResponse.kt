package com.example.retrofitapp.model.response

import com.example.retrofitapp.model.User

data class UserResponse(
    val code: Int,
    val status: String,
    val userList : List<User>
)

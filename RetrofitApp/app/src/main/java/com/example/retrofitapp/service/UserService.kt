package com.example.retrofitapp.service

import com.example.retrofitapp.model.User
import com.example.retrofitapp.model.response.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface UserService {

    @GET("user_list.php")
    fun getListUser(): Call<UserResponse>

}
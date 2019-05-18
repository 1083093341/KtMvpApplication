package com.zwr.ktmvpapplication.net


import com.zwr.ktmvpapplication.login.User
import io.reactivex.Observable
import retrofit2.http.*


interface APIService {

    //登录接口
    @GET("login")//登录接口名字
    fun login(
            @Query("userName") userName: String,
            @Query("password") password: String): Observable<User>
}
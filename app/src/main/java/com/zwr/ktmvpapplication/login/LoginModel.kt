package com.zwr.ktmvpapplication.login

import com.zwr.ktmvpapplication.net.RetrofitClient
import io.reactivex.Observable

/**
 * 登录模块的model
 */
class LoginModel: ILoginModel{
    override fun login(userName: String, password: String): Observable<User> {
        return RetrofitClient.getApi().login(userName, password)
    }

}

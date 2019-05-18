package com.zwr.ktmvpapplication.login

import io.reactivex.Observable

/**
 * model层的接口，个人觉得可写可不写
 */
interface ILoginModel {

   fun login(userName: String,password: String): Observable<User>
}
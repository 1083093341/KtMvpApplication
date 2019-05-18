package com.zwr.ktmvpapplication.login

/**
 * 登录界面的接口
 */
interface ILoginView {
    fun showInfoStr(msg: String)
    fun loginSuccess(it: User)
}
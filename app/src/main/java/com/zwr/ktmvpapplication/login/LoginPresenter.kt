package com.zwr.ktmvpapplication.login

import android.annotation.SuppressLint
import com.shengxun.app.base.BasePresenter
import io.reactivex.schedulers.Schedulers
import com.zwr.ktmvpapplication.MainActivity
import io.reactivex.android.schedulers.AndroidSchedulers


class LoginPresenter(private val loginView: ILoginView) : BasePresenter<MainActivity>() {

    private val mainManger = LoginModel()

    //LoginInterface
    @SuppressLint("CheckResult")
    fun login(userName: String, password: String) {

        mainManger.login(userName, password)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
//                    if("成功"){
//                        loginView.loginSuccess(it)
//                    }else{
//                        loginView.showInfoStr("错误信息")
//                    }

                }, {
                    loginView.showInfoStr(it.message!!)

                })

    }


}

package com.zwr.ktmvpapplication

import android.os.Bundle
import com.zwr.ktmvpapplication.base.BaseActivity
import com.zwr.ktmvpapplication.login.ILoginView
import com.zwr.ktmvpapplication.login.LoginPresenter
import com.zwr.ktmvpapplication.login.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainActivity, LoginPresenter>(), ILoginView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }


    /**
     * 创建你的LoginPresenter
     */
    override fun createPresenter(): LoginPresenter {
       return LoginPresenter(this)
    }

    /**
     * 初始化方法
     */
    override fun init() {
        //按钮点击
        btnLogin.setOnClickListener {
            mPresenter!!.login(edtUserName.text.toString(),edtPassword.text.toString())
        }
    }

    /**
     * View的回调方法
     * 提示相关信息
     */
    override fun showInfoStr(msg: String) {
        msg.toast(this)
    }

    /**
     * View的回调方法
     * 登录成功回调
     */
    override fun loginSuccess(it: User) {
    }
}

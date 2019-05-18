package com.zwr.ktmvpapplication.base


import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.Toast
import com.shengxun.app.base.BasePresenter

abstract class BaseActivity<V, T : BasePresenter<V>> : AppCompatActivity(){

    protected var mPresenter: T? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = createPresenter()
        mPresenter?.attachView(this as V)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.detachView()
    }

    //创建一个Presenter(
    protected abstract fun createPresenter(): T
    //每个子类的初始化方法
    protected abstract fun init()


    /**
     * toast
     */
    protected fun Any.toast(context: Context, duration: Int = Toast.LENGTH_SHORT): Toast {
        val makeText = Toast.makeText(context, this.toString(), duration)
        makeText.setGravity(Gravity.CENTER, 0, 0)
        return makeText.apply { show() }
    }

}

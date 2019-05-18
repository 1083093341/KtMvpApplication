package com.zwr.ktmvpapplication.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Gravity
import android.widget.Toast
import com.shengxun.app.base.BasePresenter


abstract class BaseFragment<V, T : BasePresenter<V>> : Fragment() {
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

    protected abstract fun createPresenter(): T
    protected abstract fun init()

    protected fun Any.toast(context: Context, duration: Int = Toast.LENGTH_SHORT): Toast {
        val makeText = Toast.makeText(context, this.toString(), duration)
        makeText.setGravity(Gravity.CENTER, 0, 0)
        return makeText.apply { show() }
    }



}

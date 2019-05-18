package com.shengxun.app.base

import java.lang.ref.Reference
import java.lang.ref.WeakReference

/**
 * 弱引用View 防止内存泄漏
 * @param <T>
</T> */
abstract class BasePresenter<T> {

    protected var mViewrRef: Reference<T>? = null

    protected val view: T
        get() = mViewrRef!!.get()!!


    val isAttachView: Boolean
        get() = null != mViewrRef && null != mViewrRef!!.get()

    /**
     * 与View建立关联
     */
    fun attachView(view: T) {
        mViewrRef = WeakReference(view)
    }

    /**
     * 解除与View的关联
     */
    fun detachView() {
        if (null != mViewrRef) {
            mViewrRef!!.clear()
            mViewrRef = null
        }
    }
}

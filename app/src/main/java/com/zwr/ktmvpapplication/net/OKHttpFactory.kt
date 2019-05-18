package com.zwr.ktmvpapplication.net

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit


/**
 * 构建Okhttp
 */
class OKHttpFactory private constructor() {

    companion object {
        val instance = OKHttpFactoryHolder.singleHolder
    }

    private object OKHttpFactoryHolder {

        //日志显示级别
        val level = HttpLoggingInterceptor.Level.BODY


        //新建log拦截器 为了测试可以在控制台打印请求日志，上线可关闭
        val loggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> Log.e("网络请求", "OkHttp====Message:$message") })

       // loggingInterceptor.setLevel(level)

        val singleHolder: OkHttpClient = OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .retryOnConnectionFailure(true)
                .readTimeout(10, TimeUnit.MINUTES)
                .connectTimeout(10, TimeUnit.MINUTES)
                .writeTimeout(10, TimeUnit.MINUTES)
                .addInterceptor(loggingInterceptor.setLevel(level))
                .build()

    }

}
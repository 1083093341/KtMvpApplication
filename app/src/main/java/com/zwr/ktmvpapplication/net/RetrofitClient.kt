package com.zwr.ktmvpapplication.net

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit

class RetrofitClient private constructor() {

    companion object {
        private var server1 = "baseUrl"

        private val instance = RetrofitClientHolder.getInstance(server1)
        fun getApi(): APIService {
            return instance.create(APIService::class.java)
        }
    }

    private object RetrofitClientHolder {
        fun getInstance(serverUrl: String): Retrofit {
            return Retrofit.Builder()
                    //设置OKHttpClient
                    .client(OKHttpFactory.instance)
                    .baseUrl(serverUrl)
                    //.addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
        }
    }


}
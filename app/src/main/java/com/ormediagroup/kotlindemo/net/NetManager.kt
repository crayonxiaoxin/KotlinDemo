package com.ormediagroup.kotlindemo.net

import com.ormediagroup.kotlindemo.util.ThreadUtil
import okhttp3.*
import java.io.IOException

/**
 * Created by Lau on 2020-01-15.
 */
class NetManager private constructor() {
    val client by lazy { OkHttpClient() }

    // 单例
    companion object {
        val manager by lazy { NetManager() }
    }

    // 发送请求
    fun <RESPONSE> sendRequest(req: MRequest<RESPONSE>) {
//        val path = URLProviderUtils.getHomeUrl(0, 10)
        val request = Request.Builder()
            .url(req.url)
            .get()
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val result = response.body?.string()
                val parseResult = req.parseResult(result)
//                val gson = Gson()
//                val obj = gson.fromJson<HomeBean>(result, HomeBean::class.java)
//                println("获取数据成功" + obj.code)
                // 主线程中更新UI
                ThreadUtil.runOnMainThread(Runnable {
                    //                    homeView.onSuccess(obj.data)
                    req.handler.onSuccess(req.type, parseResult)
                })
            }

            override fun onFailure(call: Call, e: IOException) {
                ThreadUtil.runOnMainThread(Runnable {
                    //                    homeView.onError(e.message)
                    req.handler.onError(req.type, e.message)
                })
            }

        })
    }
}
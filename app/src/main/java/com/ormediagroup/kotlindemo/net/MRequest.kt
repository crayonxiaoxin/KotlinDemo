package com.ormediagroup.kotlindemo.net

import com.google.gson.Gson
import java.lang.reflect.ParameterizedType


/**
 * 所有请求的基类
 * type 根据类型确定是哪个请求
 * Created by Lau on 2020-01-15.
 */
open class MRequest<RESPONSE>(
    val type: Int,
    val url: String,
    val handler: ResponseHandler<RESPONSE>
) {
    // 解析网络请求结果
    fun parseResult(result: String?): RESPONSE {
        val gson = Gson()
        // 获取泛型的类型
        val tClass =
            (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
        return gson.fromJson(result, tClass)
    }

    // 发送网络请求
    fun execute() {
        NetManager.manager.sendRequest(this)
    }
}
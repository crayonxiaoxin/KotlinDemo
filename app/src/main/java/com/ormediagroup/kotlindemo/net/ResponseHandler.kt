package com.ormediagroup.kotlindemo.net

/**
 * 请求回调
 * Created by Lau on 2020-01-15.
 */
interface ResponseHandler<RESPONSE> {
    fun onError(type: Int, msg: String?)
    fun onSuccess(type: Int, result: RESPONSE)
}
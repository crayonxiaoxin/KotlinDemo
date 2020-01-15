package com.ormediagroup.kotlindemo.base

/**
 * Created by Lau on 2020-01-15.
 */
interface BaseView<ITEMBEAN> {
    fun onError(message: String?)
    fun loadMore(data: List<ITEMBEAN>)
    fun onSuccess(data: List<ITEMBEAN>)
}
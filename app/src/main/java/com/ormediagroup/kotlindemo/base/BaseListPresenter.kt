package com.ormediagroup.kotlindemo.base

/**
 * Created by Lau on 2020-01-15.
 */
interface BaseListPresenter {
    companion object{
        const val TYPE_INIT_OR_REFRESH = 1
        const val TYPE_LOAD_MORE = 2
    }
    fun loadData()
    fun loadMore(offset:Int)
    fun destroyView()
}
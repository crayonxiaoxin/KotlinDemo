package com.ormediagroup.kotlindemo.presenter.impl

import com.ormediagroup.kotlindemo.base.BaseListPresenter
import com.ormediagroup.kotlindemo.base.BaseView
import com.ormediagroup.kotlindemo.model.HomeBean
import com.ormediagroup.kotlindemo.model.HomeData
import com.ormediagroup.kotlindemo.net.HomeRequest
import com.ormediagroup.kotlindemo.net.ResponseHandler
import com.ormediagroup.kotlindemo.presenter.`interface`.HomePresenter

/**
 * presenter 接口实现类
 * 实现HomePresenter中的接口并且把更新UI的操作回调到View层
 * Created by Lau on 2020-01-15.
 */
class HomePresenterImpl(var homeView: BaseView<HomeData>?) : HomePresenter, ResponseHandler<HomeBean> {

    override fun destroyView() {
        if (homeView != null) homeView = null
    }

    override fun onError(type: Int, msg: String?) {
        homeView?.onError(msg)
    }

    override fun onSuccess(type: Int, result: HomeBean) {
        when (type) {
            BaseListPresenter.TYPE_INIT_OR_REFRESH -> {
                homeView?.onSuccess(result.data)
            }
            BaseListPresenter.TYPE_LOAD_MORE -> {
                homeView?.loadMore(result.data)
            }
        }
    }

    override fun loadData() {
        HomeRequest(BaseListPresenter.TYPE_INIT_OR_REFRESH, 0, this).execute()
//        val path = URLProviderUtils.getHomeUrl(0, 10)
//        val client = OkHttpClient()
//        val request = Request.Builder()
//            .url(path)
//            .get()
//            .build()
//        client.newCall(request).enqueue(object : Callback {
//            override fun onResponse(call: Call, response: Response) {
////                showMsg("获取数据成功")
//                val result = response.body?.string()
//                val gson = Gson()
//                val obj = gson.fromJson<HomeBean>(result, HomeBean::class.java)
//                println("获取数据成功" + obj.code)
//                // 主线程中更新UI
//                ThreadUtil.runOnMainThread(Runnable {
////                    swipeRefreshLayout.isRefreshing = false
////                    adapter.updateList(obj.data)
//                    homeView.onSuccess(obj.data)
//                })
//            }
//
//            override fun onFailure(call: Call, e: IOException) {
////                showMsg("获取数据失败")
//                ThreadUtil.runOnMainThread(Runnable {
//                    homeView.onError(e.message)
////                    swipeRefreshLayout.isRefreshing = false
//                })
//            }
//
//        })
    }

    override fun loadMore(offset: Int) {
        HomeRequest(BaseListPresenter.TYPE_LOAD_MORE, offset, this).execute()
//        val path = URLProviderUtils.getHomeUrl(offset, 10)
//        val client = OkHttpClient()
//        val request = Request.Builder()
//            .url(path)
//            .get()
//            .build()
//        client.newCall(request).enqueue(object : Callback {
//            override fun onResponse(call: Call, response: Response) {
////                showMsg("获取数据成功")
//                val result = response.body?.string()
//                val gson = Gson()
//                val obj = gson.fromJson<HomeBean>(result, HomeBean::class.java)
////                println("获取数据成功" + obj.code)
//                // 主线程中更新UI
//                ThreadUtil.runOnMainThread(Runnable {
//                    //                    swipeRefreshLayout.isRefreshing = false
////                    adapter.loadMore(obj.data)
//                    homeView.loadMore(obj.data)
//                })
//            }
//
//            override fun onFailure(call: Call, e: IOException) {
////                showMsg("获取数据失败")
//                ThreadUtil.runOnMainThread(Runnable {
//                    homeView.onError(e.message)
////                    swipeRefreshLayout.isRefreshing = false
//                })
//            }

//    })
    }

}
package com.ormediagroup.kotlindemo.ui.fragment

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ormediagroup.kotlindemo.R
import com.ormediagroup.kotlindemo.adapter.HomeAdapter
import com.ormediagroup.kotlindemo.base.BaseFragment
import com.ormediagroup.kotlindemo.model.HomeBean
import com.ormediagroup.kotlindemo.util.ThreadUtil
import com.ormediagroup.kotlindemo.util.URLProviderUtils
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.*
import org.jetbrains.anko.error
import org.jetbrains.anko.info
import java.io.IOException

/**
 * Created by Lau on 2020-01-14.
 */
class HomeFragment : BaseFragment() {
    val adapter by lazy { HomeAdapter() }
    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_home, null)
    }

    override fun initListener() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        swipeRefreshLayout.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE)
        swipeRefreshLayout.setOnRefreshListener { loadData(0) }

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                val layoutManager = recyclerView.layoutManager
                if (layoutManager is LinearLayoutManager) {
                    val manager = layoutManager
                    val lastPosition = manager.findLastVisibleItemPosition()
                    if (lastPosition == adapter.itemCount - 1) {
                        loadData(adapter.itemCount - 1)
                    }
                }
            }
        })
    }

    override fun initData() {
        loadData(0)
    }

    private fun loadData(offset: Int) {
        val path = URLProviderUtils.getHomeUrl(offset, 10)
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(path)
            .get()
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                showMsg("获取数据成功")
                val result = response.body?.string()
                val gson = Gson()
                val obj = gson.fromJson<HomeBean>(result, HomeBean::class.java)
                println("获取数据成功" + obj.code)
                // 主线程中更新UI
                ThreadUtil.runOnMainThread(Runnable {
                    swipeRefreshLayout.isRefreshing = false
                    adapter.loadMore(obj.data)
                })
            }

            override fun onFailure(call: Call, e: IOException) {
                showMsg("获取数据失败")
                ThreadUtil.runOnMainThread(Runnable { swipeRefreshLayout.isRefreshing = false })
            }

        })
    }
}
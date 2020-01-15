package com.ormediagroup.kotlindemo.base

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.ormediagroup.kotlindemo.R
import com.ormediagroup.kotlindemo.adapter.YueDanAdapter
import com.ormediagroup.kotlindemo.base.BaseFragment
import com.ormediagroup.kotlindemo.model.PlayLists
import com.ormediagroup.kotlindemo.presenter.`interface`.YueDanPresenter
import com.ormediagroup.kotlindemo.presenter.impl.YueDanPresenterImpl
import com.ormediagroup.kotlindemo.util.URLProviderUtils
import com.ormediagroup.kotlindemo.view.YueDanView
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.error

/**
 * Created by Lau on 2020-01-14.
 */
abstract class BaseListFragment<RESPONSE,ITEMBEAN,ITEMVIEW:View> : BaseFragment(), BaseView<ITEMBEAN> {
    override fun onError(message: String?) {
        showMsg("加载数据失败")
        swipeRefreshLayout?.isRefreshing = false
    }

    override fun loadMore(data: List<ITEMBEAN>) {
        adapter.updateList(data)
    }

    override fun onSuccess(data: List<ITEMBEAN>) {
        swipeRefreshLayout?.isRefreshing = false
        adapter.updateList(data)
    }

//    override fun onError(msg: String?) {
//        swipeRefreshLayout?.isRefreshing = false
//        showMsg("加载数据失败")
//    }
//
//    override fun onSuccess(playLists: List<PlayLists>) {
//        swipeRefreshLayout?.isRefreshing = false
//        showMsg("加载数据成功")
//        adapter.updateList(playLists)
//    }
//
//    override fun loadMore(playLists: List<PlayLists>) {
//        swipeRefreshLayout?.isRefreshing = false
//        showMsg("加载数据成功")
//        adapter.loadMore(playLists)
//    }

    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_home, null)
    }

    val adapter by lazy { getListAdapter() }

    abstract fun getListAdapter(): BaseListAdapter<ITEMBEAN,ITEMVIEW>

    val presenter by lazy { getListPresenter() }

    abstract fun getListPresenter(): BaseListPresenter

    override fun initData() {
        presenter.loadData()
    }

    override fun initListener() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        swipeRefreshLayout.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE)
        swipeRefreshLayout.setOnRefreshListener { presenter.loadData() }

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                val manager = recyclerView.layoutManager
                if (manager is LinearLayoutManager) {
                    var lastPosition = manager.findLastVisibleItemPosition()
                    if (lastPosition == adapter.itemCount - 1) {
                        presenter.loadMore(adapter.itemCount - 1)
                    }
                }
            }
        })
    }
}
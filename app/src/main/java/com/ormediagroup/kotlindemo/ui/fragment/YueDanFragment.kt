package com.ormediagroup.kotlindemo.ui.fragment

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ormediagroup.kotlindemo.R
import com.ormediagroup.kotlindemo.adapter.YueDanAdapter
import com.ormediagroup.kotlindemo.base.BaseFragment
import com.ormediagroup.kotlindemo.base.BaseListAdapter
import com.ormediagroup.kotlindemo.base.BaseListFragment
import com.ormediagroup.kotlindemo.base.BaseListPresenter
import com.ormediagroup.kotlindemo.model.PlayLists
import com.ormediagroup.kotlindemo.model.YueDanBean
import com.ormediagroup.kotlindemo.model.YueDanData
import com.ormediagroup.kotlindemo.presenter.impl.YueDanPresenterImpl
import com.ormediagroup.kotlindemo.view.YueDanView
import com.ormediagroup.kotlindemo.widget.YueDanItemView
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by Lau on 2020-01-14.
 * 可变的
 * YueDanView
 * YueDanAdapter
 * YueDanPresenterImpl
 */
class YueDanFragment : BaseListFragment<YueDanBean, PlayLists, YueDanItemView>() {
    override fun getListAdapter(): BaseListAdapter<PlayLists, YueDanItemView> {
        return YueDanAdapter()
    }

    override fun getListPresenter(): BaseListPresenter {
        return YueDanPresenterImpl(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.destroyView()
    }
}
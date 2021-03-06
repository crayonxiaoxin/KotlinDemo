package com.ormediagroup.kotlindemo.ui.fragment

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ormediagroup.kotlindemo.R
import com.ormediagroup.kotlindemo.adapter.HomeAdapter
import com.ormediagroup.kotlindemo.base.BaseFragment
import com.ormediagroup.kotlindemo.base.BaseListAdapter
import com.ormediagroup.kotlindemo.base.BaseListFragment
import com.ormediagroup.kotlindemo.base.BaseListPresenter
import com.ormediagroup.kotlindemo.model.HomeBean
import com.ormediagroup.kotlindemo.model.HomeData
import com.ormediagroup.kotlindemo.presenter.impl.HomePresenterImpl
import com.ormediagroup.kotlindemo.view.HomeView
import com.ormediagroup.kotlindemo.widget.HomeItemView
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.support.v4.find

/**
 * Created by Lau on 2020-01-14.
 */
class HomeFragment : BaseListFragment<HomeBean, HomeData, HomeItemView>() {
    override fun getListAdapter(): BaseListAdapter<HomeData, HomeItemView> {
        return HomeAdapter()
    }

    override fun getListPresenter(): BaseListPresenter {
        return HomePresenterImpl(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.destroyView()
    }
}
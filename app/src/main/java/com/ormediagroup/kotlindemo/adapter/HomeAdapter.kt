package com.ormediagroup.kotlindemo.adapter

import android.content.Context
import com.ormediagroup.kotlindemo.base.BaseListAdapter
import com.ormediagroup.kotlindemo.model.HomeData
import com.ormediagroup.kotlindemo.widget.HomeItemView

/**
 * Created by Lau on 2020-01-14.
 */
class HomeAdapter : BaseListAdapter<HomeData, HomeItemView>() {
    override fun getItemView(context: Context): HomeItemView {
        return HomeItemView(context)
    }

    override fun setData(data: HomeData, item: HomeItemView) {
        item.setData(data)
    }
}
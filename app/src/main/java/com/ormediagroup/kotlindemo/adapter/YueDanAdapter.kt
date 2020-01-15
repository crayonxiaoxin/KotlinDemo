package com.ormediagroup.kotlindemo.adapter

import android.content.Context
import com.ormediagroup.kotlindemo.base.BaseListAdapter
import com.ormediagroup.kotlindemo.model.PlayLists
import com.ormediagroup.kotlindemo.widget.YueDanItemView

/**
 * Created by Lau on 2020-01-15.
 */
class YueDanAdapter : BaseListAdapter<PlayLists, YueDanItemView>() {
    override fun getItemView(context: Context): YueDanItemView {
        return YueDanItemView(context)
    }

    override fun setData(data: PlayLists, item: YueDanItemView) {
        item.setData(data)
    }
}

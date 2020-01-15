package com.ormediagroup.kotlindemo.base

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ormediagroup.kotlindemo.widget.LoadMoreView

/**
 * Created by Lau on 2020-01-15.
 */

abstract class BaseListAdapter<ITEMBEAN, ITEMVIEW : View> :
    RecyclerView.Adapter<BaseListAdapter.BaseListHolder>() {
    private val list = ArrayList<ITEMBEAN>()
    fun updateList(list: List<ITEMBEAN>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    fun loadMore(list: List<ITEMBEAN>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseListHolder {
        return if (viewType == 0) {
            BaseListHolder(getItemView(parent.context))
        } else {
            BaseListHolder(LoadMoreView(parent.context))
        }
    }


    override fun getItemCount(): Int {
        return this.list.size + 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == this.list.size) {
            1
        } else {
            0
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: BaseListHolder, position: Int) {
        if (position == this.list.size) return
        val item = holder.itemView as ITEMVIEW
//        item.setData(this.list[position])
        setData(this.list[position], item)
    }


    class BaseListHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    abstract fun setData(data: ITEMBEAN, item: ITEMVIEW)
    abstract fun getItemView(context: Context): ITEMVIEW

}
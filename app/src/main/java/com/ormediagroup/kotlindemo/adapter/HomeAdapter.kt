package com.ormediagroup.kotlindemo.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ormediagroup.kotlindemo.model.Data
import com.ormediagroup.kotlindemo.widget.HomeItemView
import com.ormediagroup.kotlindemo.widget.LoadMoreView

/**
 * Created by Lau on 2020-01-14.
 */
class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeHolder>() {
    private var list = ArrayList<Data>()
    fun updateList(list: List<Data>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    fun loadMore(list: List<Data>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == list.size) {
            1
        } else {
            0
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        return if (viewType == 0) {
            HomeHolder(HomeItemView(parent.context))
        } else {
            HomeHolder(LoadMoreView(parent.context))
        }
    }

    override fun getItemCount(): Int {
        return this.list.size + 1
    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        if (position == list.size) return
        var item = holder.itemView as HomeItemView
        item.setData(list.get(position))
    }

    class HomeHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
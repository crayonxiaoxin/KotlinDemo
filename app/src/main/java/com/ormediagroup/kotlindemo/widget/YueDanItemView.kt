package com.ormediagroup.kotlindemo.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.ormediagroup.kotlindemo.R
import com.ormediagroup.kotlindemo.model.PlayLists
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_yuedan.view.*

/**
 * Created by Lau on 2020-01-15.
 */
class YueDanItemView : RelativeLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        View.inflate(context, R.layout.item_yuedan, this)
    }

    fun setData(data: PlayLists) {
        title.text = data.title
        count.text = data.videoCount.toString()
        desc.text = data.description
        Picasso.get().load(data.creator.largeAvatar).into(avatar)
        Picasso.get().load(data.playListBigPic).into(image)
    }
}
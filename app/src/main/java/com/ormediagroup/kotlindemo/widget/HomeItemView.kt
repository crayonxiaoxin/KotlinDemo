package com.ormediagroup.kotlindemo.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import androidx.core.view.ViewCompat
import com.ormediagroup.kotlindemo.R
import com.ormediagroup.kotlindemo.model.Data
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_settings.view.*
import kotlinx.android.synthetic.main.item_home.view.*


/**
 * Created by Lau on 2020-01-14.
 */
class HomeItemView : RelativeLayout {
    // 次构方法
    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        View.inflate(context, R.layout.item_home, this)
    }

    fun setData(data: Data) {
        title.setText(data.title)
        desc.setText(data.description)
        Picasso.get().load(data.posterPic).into(image)
    }
}
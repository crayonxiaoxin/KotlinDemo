package com.ormediagroup.kotlindemo.ui.fragment

import android.view.View
import com.ormediagroup.kotlindemo.R
import com.ormediagroup.kotlindemo.base.BaseFragment

/**
 * Created by Lau on 2020-01-14.
 */
class VBangFragment : BaseFragment() {
    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_vbang, null)
    }
}
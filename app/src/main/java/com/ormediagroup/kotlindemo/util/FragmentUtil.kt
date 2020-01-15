package com.ormediagroup.kotlindemo.util

import com.ormediagroup.kotlindemo.R
import com.ormediagroup.kotlindemo.base.BaseFragment
import com.ormediagroup.kotlindemo.ui.fragment.HomeFragment
import com.ormediagroup.kotlindemo.ui.fragment.MVFragment
import com.ormediagroup.kotlindemo.ui.fragment.YueDanFragment
import com.ormediagroup.kotlindemo.ui.fragment.VBangFragment

/**
 * Created by Lau on 2020-01-14.
 */
class FragmentUtil private constructor() {
    val homeFragment by lazy { HomeFragment() }
    val mvFragment by lazy { MVFragment() }
    val vBangFragment by lazy { VBangFragment() }
    val mvListFragment by lazy { YueDanFragment() }

    companion object {
        val fragmentUtil by lazy { FragmentUtil() }
    }

    fun getFragment(tabId: Int): BaseFragment? {
        return when (tabId) {
            R.id.home -> homeFragment
            R.id.mv -> mvFragment
            R.id.vbang -> vBangFragment
            R.id.mv_list -> mvListFragment
            else -> null
        }
    }
}
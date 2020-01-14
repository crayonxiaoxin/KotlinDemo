package com.ormediagroup.kotlindemo.ui.activity

import androidx.appcompat.widget.Toolbar
import androidx.preference.PreferenceManager
import com.ormediagroup.kotlindemo.R
import com.ormediagroup.kotlindemo.base.BaseActivity
import com.ormediagroup.kotlindemo.util.ToolbarManager
import org.jetbrains.anko.find

/**
 * Created by Lau on 2020-01-14.
 */
class SettingsActivity : BaseActivity(), ToolbarManager {
    override val toolBar: Toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun getLayoutId(): Int {
        return R.layout.activity_settings
    }

    override fun initData() {
        initSettingToolbar()
        var sp = PreferenceManager.getDefaultSharedPreferences(this)
        var push = sp.getBoolean("push", false)
        showMsg("push=" + push)
    }
}
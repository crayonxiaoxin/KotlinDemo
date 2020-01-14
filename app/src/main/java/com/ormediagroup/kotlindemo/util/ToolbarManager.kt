package com.ormediagroup.kotlindemo.util

import android.content.Intent
import androidx.appcompat.widget.Toolbar
import com.ormediagroup.kotlindemo.R
import com.ormediagroup.kotlindemo.ui.activity.SettingsActivity


/**
 * Toolbar 管理
 * Created by Lau on 2020-01-14.
 */
interface ToolbarManager {
    val toolBar: Toolbar
    fun initMainToolbar() {
        toolBar.setTitle("测试影音")
        toolBar.inflateMenu(R.menu.main)
        toolBar.setOnMenuItemClickListener {
            if (it.itemId == R.id.settings)
                toolBar.context.startActivity(Intent(toolBar.context, SettingsActivity::class.java))
            true
        }
    }

    fun initSettingToolbar() {
        toolBar.setTitle("设置")
    }
}
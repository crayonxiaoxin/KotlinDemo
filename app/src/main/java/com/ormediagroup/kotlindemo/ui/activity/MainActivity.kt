package com.ormediagroup.kotlindemo.ui.activity

import androidx.appcompat.widget.Toolbar
import com.ormediagroup.kotlindemo.R
import com.ormediagroup.kotlindemo.base.BaseActivity
import com.ormediagroup.kotlindemo.util.FragmentUtil
import com.ormediagroup.kotlindemo.util.ToolbarManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.find

class MainActivity : BaseActivity(), ToolbarManager {
    override val toolBar: Toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
        initMainToolbar()
    }

    override fun initListener() {
        bottomBar.setOnNavigationItemSelectedListener {
            val transition = supportFragmentManager.beginTransaction()
            showMsg(it.toString())
            // ?.let 当不为null才执行{}
            FragmentUtil.fragmentUtil.getFragment(it.itemId)?.let { it1 ->
                transition.replace(
                    R.id.container,
                    it1,
                    it.itemId.toString()
                )
            }
            transition.commit()
            true
        }
        // 在listener之后设置才会触发listener
        bottomBar.selectedItemId = R.id.home
    }

}

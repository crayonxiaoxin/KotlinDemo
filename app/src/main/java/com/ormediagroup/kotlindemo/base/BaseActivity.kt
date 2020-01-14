package com.ormediagroup.kotlindemo.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.ormediagroup.kotlindemo.ui.activity.MainActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * Created by Lau on 2020-01-13.
 */
abstract class BaseActivity : AppCompatActivity(), AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initListener()
        initData()
    }

    // 初始化数据
    open protected fun initData() {

    }

    // adapter listener
    open protected fun initListener() {

    }

    // 获取布局id
    abstract fun getLayoutId(): Int

    // Toast
    protected fun showMsg(msg: String) {
        runOnUiThread { toast(msg) }
    }

    protected inline fun <reified T : BaseActivity> startActivityAndFinish() {
        startActivity<T>()
        finish()
    }
}
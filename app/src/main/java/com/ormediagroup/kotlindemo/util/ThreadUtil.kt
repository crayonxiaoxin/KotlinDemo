package com.ormediagroup.kotlindemo.util

import android.os.Handler
import android.os.Looper


/**
 * Created by Lau on 2020-01-14.
 */
object ThreadUtil {
    val handler = Handler(Looper.getMainLooper())
    fun runOnMainThread(runnable: Runnable) {
        handler.post(runnable)
    }
}
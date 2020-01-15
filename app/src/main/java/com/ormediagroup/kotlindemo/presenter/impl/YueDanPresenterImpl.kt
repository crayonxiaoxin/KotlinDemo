package com.ormediagroup.kotlindemo.presenter.impl

import com.ormediagroup.kotlindemo.base.BaseListPresenter
import com.ormediagroup.kotlindemo.base.BaseView
import com.ormediagroup.kotlindemo.model.PlayLists
import com.ormediagroup.kotlindemo.model.YueDanBean
import com.ormediagroup.kotlindemo.net.ResponseHandler
import com.ormediagroup.kotlindemo.net.YueDanRequest
import com.ormediagroup.kotlindemo.presenter.`interface`.YueDanPresenter

/**
 * Created by Lau on 2020-01-15.
 */
class YueDanPresenterImpl(var yueDanView: BaseView<PlayLists>?) : YueDanPresenter,
    ResponseHandler<YueDanBean> {
    override fun destroyView() {
        if (yueDanView != null) yueDanView = null
    }

    override fun onError(type: Int, msg: String?) {
        yueDanView?.onError(msg)
    }

    override fun onSuccess(type: Int, result: YueDanBean) {
        println(result.toString())
        when (type) {
            BaseListPresenter.TYPE_INIT_OR_REFRESH -> {
                yueDanView?.onSuccess(result.data.playLists)
            }
            BaseListPresenter.TYPE_LOAD_MORE -> {
                yueDanView?.loadMore(result.data.playLists)
            }
        }
    }

    override fun loadData() {
        YueDanRequest(BaseListPresenter.TYPE_INIT_OR_REFRESH, 0, this).execute()
    }

    override fun loadMore(offset: Int) {
        YueDanRequest(BaseListPresenter.TYPE_LOAD_MORE, offset, this).execute()
    }
}
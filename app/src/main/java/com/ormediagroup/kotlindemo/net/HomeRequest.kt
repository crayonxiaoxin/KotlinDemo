package com.ormediagroup.kotlindemo.net

import com.ormediagroup.kotlindemo.model.HomeBean
import com.ormediagroup.kotlindemo.util.URLProviderUtils

/**
 * Created by Lau on 2020-01-15.
 */
class HomeRequest(type: Int, offset: Int, handler: ResponseHandler<HomeBean>) :
    MRequest<HomeBean>(
        type,
        URLProviderUtils.getHomeUrl(offset, 20),
        handler
    )
package com.ormediagroup.kotlindemo.net

import com.ormediagroup.kotlindemo.model.YueDanBean
import com.ormediagroup.kotlindemo.util.URLProviderUtils

/**
 * Created by Lau on 2020-01-15.
 */
class YueDanRequest(type: Int, offset: Int, handler: ResponseHandler<YueDanBean>) :
    MRequest<YueDanBean>(
        type,
        URLProviderUtils.getYueDanUrl(offset, 20),
        handler
    )
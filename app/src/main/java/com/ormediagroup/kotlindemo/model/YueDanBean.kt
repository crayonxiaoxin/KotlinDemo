package com.ormediagroup.kotlindemo.model

/**
 * Created by Lau on 2020-01-15.
 */
data class YueDanBean(
    val code: String,
    val cost: Int,
    val `data`: YueDanData,
    val msg: String,
    val now: Long
)

data class YueDanData(
    val playLists: List<PlayLists>,
    val totalCount: Int
)

data class PlayLists(
    val category: String,
    val createdTime: String,
    val creator: Creator,
    val description: String,
    val id: Int,
    val integral: Int,
    val playListBigPic: String,
    val playListPic: String,
    val rank: Int,
    val status: Int,
    val thumbnailPic: String,
    val title: String,
    val totalFavorites: Int,
    val totalUser: Int,
    val totalViews: Int,
    val updateTime: String,
    val videoCount: Int,
    val weekIntegral: Int
)

data class Creator(
    val largeAvatar: String,
    val nickName: String,
    val smallAvatar: String,
    val uid: Int,
    val vipLevel: Int,
    val woLevel: Int,
    val woWithDraw: Boolean
)
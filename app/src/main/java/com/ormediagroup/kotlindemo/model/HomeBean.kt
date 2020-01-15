package com.ormediagroup.kotlindemo.model

/**
 * Created by Lau on 2020-01-14.
 */
data class HomeBean(
    val code: String,
    val cost: Int,
    val `data`: List<HomeData>,
    val msg: String,
    val now: Long
)

data class HomeData(
    val clickUrl: String,
    val description: String,
    val hdUrl: String,
    val hdVideoSize: Int,
    val id: Int,
    val posterPic: String,
    val status: Int,
    val subType: String,
    val thumbnailPic: String,
    val title: String,
    val type: String,
    val uhdUrl: String,
    val uhdVideoSize: Int,
    val url: String,
    val videoSize: Int
)
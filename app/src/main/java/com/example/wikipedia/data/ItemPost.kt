package com.example.wikipedia.data


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemPost(
    val urlImage : String ,
    val title : String ,
    val subtitle : String ,
    val detail : String ,
    val isTrend : Boolean ,
    val inSight : String ,
    val url : String
) : Parcelable

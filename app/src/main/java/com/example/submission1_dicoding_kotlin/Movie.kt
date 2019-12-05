package com.example.submission1_dicoding_kotlin

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    var photo:Int,
    var name:String?,
    var desc:String?,
    var rating:String?,
    var backdrop:Int

): Parcelable


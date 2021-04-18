package com.miqdad71.myhero.Data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Hero(
    var name: String = "",
    var times: String = "",
    var detail: String = "",
    var photo: Int = 0
) : Parcelable
package com.example.phonecontacts

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contact_kt(
        val name:String,
        val phoneNumber:String,
        val imageId:Int,
        val description:String,

):Parcelable

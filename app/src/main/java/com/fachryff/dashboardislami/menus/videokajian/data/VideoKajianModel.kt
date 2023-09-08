package com.fachryff.dashboardislami.menus.videokajian.data

import android.icu.text.CaseMap
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.nio.channels.spi.AbstractInterruptibleChannel

@Parcelize
data class VideoKajianModel(
    var thumbnail : Int = 0,
    var channel:  String = "",
    var speaker : String = "",
    var title : String = "",
    var urlVideo : String = "",
    var summary  : String = "",

) : Parcelable


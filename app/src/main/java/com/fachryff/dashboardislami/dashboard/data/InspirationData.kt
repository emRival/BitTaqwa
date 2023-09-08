package com.fachryff.dashboardislami.dashboard.data

import android.media.Image
import com.fachryff.dashboardislami.R
import com.fachryff.dashboardislami.dashboard.model.InspirationModel

object InspirationData {
    private val inspirationImage = intArrayOf(
        R.drawable.img_inspiration,
        R.drawable.img_inspiration
    )

    val listData: ArrayList<InspirationModel>
        get() {
            val list = arrayListOf<InspirationModel>()
            for (position in inspirationImage.indices) {
                val inspiration = InspirationModel()
                inspiration.inspirationImage = inspirationImage[position]
                list.add(inspiration)
            }
            return list

        }
}


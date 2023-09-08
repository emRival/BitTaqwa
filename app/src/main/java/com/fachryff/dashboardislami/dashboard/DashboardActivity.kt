package com.fachryff.dashboardislami.dashboard

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.fachryff.dashboardislami.R
import com.fachryff.dashboardislami.dashboard.adapter.InspirationListAdapter
import com.fachryff.dashboardislami.dashboard.data.InspirationData
import com.fachryff.dashboardislami.dashboard.model.InspirationModel
import com.fachryff.dashboardislami.databinding.ActivityDashboardBinding
import com.fachryff.dashboardislami.menus.doa.MenuDoaActivity
import com.fachryff.dashboardislami.menus.dzikir.MenuDzikirActivity
import com.fachryff.dashboardislami.menus.jadwalsholat.MenuJadwalSholatActivity
import com.fachryff.dashboardislami.menus.videokajian.MenuVideoKajianActivity
import com.fachryff.dashboardislami.menus.zakat.MenuZakatActivity
import java.text.SimpleDateFormat
import java.util.*


class DashboardActivity : AppCompatActivity() {

    // variable untuk mengikat layout ke class
    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // mendaftarkan layout activity_dashboard.xml
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        // variable view untuk menampung component layout
        val view = binding.root
        // menentukan tampilan dengan data yang ada di variable view (binding)
        setContentView(view)


    // memanggil fungsi
    initNavMenu()
    initRecyclerViewInspiration()
    initHeader()

    }
    // berfungsi untuk berpindah activity

    private fun initNavMenu(){

        // memberikan perintah klik pada komponen iv_icon_menu_doa
        binding.ivIconMenuDoa.setOnClickListener {
            // memulai activity baru dengan intent sebagai pembawa alamat activity yang ingin dituju
            startActivity(Intent(this, MenuDoaActivity::class.java))
        }

        binding.ivIconMenuDzikir.setOnClickListener {
            startActivity(Intent(this, MenuDzikirActivity::class.java))
        }

        binding.ivIconMenuJadwalSholat.setOnClickListener {
            startActivity(Intent(this, MenuJadwalSholatActivity::class.java))
        }

        binding.ivIconMenuVideoKajian.setOnClickListener {
            startActivity(Intent(this, MenuVideoKajianActivity::class.java))
        }

        binding.ivIconMenuZakat.setOnClickListener {
            startActivity(Intent(this, MenuZakatActivity::class.java))
        }

    }

    // fungsi untuk menampilkan data dari adapter ke komponen recycleview
    private fun initRecyclerViewInspiration(){
        // variable list untuk menampung data dari object InspirationData
        val list: ArrayList<InspirationModel> = arrayListOf()
        // memasukan semua data ke dalam variable list
        list.addAll(InspirationData.listData)

        // membuat object InspirationListAdapter
        val listInspirationAdapter = InspirationListAdapter(list)

        // mengatur ukuran recyclerview agar fix
        binding.rvInspiration.setHasFixedSize(true)
        // mengatur tampilan recyclerview agar sejajar secara vertical
        binding.rvInspiration.layoutManager = LinearLayoutManager(this)
        // memasang adapter ke recyclerview
        binding.rvInspiration.adapter = listInspirationAdapter


    }

    private fun initHeader(){
        //menampung variable yang memuat data waktu
        val timeNow = Calendar.getInstance()
        val timeFormat = SimpleDateFormat("HH")
        val time = timeFormat.format(timeNow.time)

        when {
            time.toInt() in 0..6 -> {
                binding.ivHeader.setBackgroundResource(R.drawable.bg_header_dashboard_night)

            }
            time.toInt() in 7..12 -> {
                binding.ivHeader.setBackgroundResource(R.drawable.bg_header_dashboard_morning)

            }
            time.toInt() in 13..18 -> {
                binding.ivHeader.setBackgroundResource(R.drawable.bg_header_dashboard_afternoon)

            }
            time.toInt() in 19..23 -> {
                binding.ivHeader.setBackgroundResource(R.drawable.bg_header_dashboard_night)
            }

        }
    }


}
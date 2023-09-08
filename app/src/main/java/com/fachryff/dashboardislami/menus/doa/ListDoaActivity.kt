package com.fachryff.dashboardislami.menus.doa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.fachryff.dashboardislami.R
import com.fachryff.dashboardislami.databinding.ActivityListDoaBinding
import com.fachryff.dashboardislami.menus.doa.adapter.DoaListAdapter
import com.fachryff.dashboardislami.menus.doa.data.*
import com.fachryff.dashboardislami.menus.doa.model.DoaModel

class ListDoaActivity : AppCompatActivity() {

    private lateinit var binding : ActivityListDoaBinding
    lateinit var title: String
    var logo: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListDoaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        title = intent.getStringExtra("ext_title").toString()
        logo = intent.getIntExtra("ext_icon", 0)

        setSupportActionBar(binding.toolbarListDetailDoa)
        supportActionBar?.title = title
        initRecyclerview()
    }

    private fun initRecyclerview() {
        val list: ArrayList<DoaModel> = arrayListOf()
        when (title) {
            getString(R.string.text_pagi_amp_malam) -> list.addAll(DoaPagiDanMalamData.listDoaPagiDanMalamData)
            getString(R.string.text_rumah) -> list.addAll(DoaRumahData.listDoaRumahData)
            getString(R.string.text_makanan_amp_minuman) -> list.addAll(DoaMakananDanMinumanData.listDoaMakananDanMinumanData)
            getString(R.string.text_perjalanan) -> list.addAll(DoaPerjalananData.listDoaPerjalananData)
            getString(R.string.text_sholat) -> list.addAll(DoaSholatData.listDoaShalatData)
            getString(R.string.text_etika_baik) -> list.addAll(DoaEtikaBaikData.listDoaEtikaBaikData)
        }
        binding.rvDoa.setHasFixedSize(true)
        binding.rvDoa.layoutManager = LinearLayoutManager(this)
        val listDoa = DoaListAdapter(list, title, logo)
        binding.rvDoa.adapter = listDoa
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
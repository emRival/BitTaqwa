package com.fachryff.dashboardislami.menus.videokajian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.fachryff.dashboardislami.R
import com.fachryff.dashboardislami.databinding.ActivityMenuVideoKajianBinding
import com.fachryff.dashboardislami.menus.videokajian.adapter.VideoKajianListAdapter
import com.fachryff.dashboardislami.menus.videokajian.data.VideoKajianData
import com.fachryff.dashboardislami.menus.videokajian.data.VideoKajianModel

class MenuVideoKajianActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuVideoKajianBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuVideoKajianBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.toolbarMenuVideoKajian)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val list : ArrayList<VideoKajianModel> = arrayListOf()
        binding.rvVideoKajian.setHasFixedSize(true)
        list.addAll(VideoKajianData.listData)
        binding.rvVideoKajian.layoutManager = LinearLayoutManager(this)
        val listVideoAdapter = VideoKajianListAdapter(list)
        binding.rvVideoKajian.adapter = listVideoAdapter
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
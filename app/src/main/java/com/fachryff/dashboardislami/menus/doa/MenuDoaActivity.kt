package com.fachryff.dashboardislami.menus.doa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.fachryff.dashboardislami.R
import com.fachryff.dashboardislami.databinding.ActivityMenuDoa2Binding

class MenuDoaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuDoa2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuDoa2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.tbDoa)
        initView()
    }

    private fun initView() {
        binding.cardDoaPagiMalam.setOnClickListener {
            val intent = Intent(this, ListDoaActivity::class.java)
            intent.putExtra("ext_title", getString(R.string.text_pagi_amp_malam))
            intent.putExtra("ext_icon", R.drawable.ic_doa_pagi_malam)
            startActivity(intent)
        }
        binding.cardDoaRumah.setOnClickListener {
            val intent = Intent(this, ListDoaActivity::class.java)
            intent.putExtra("ext_title", getString(R.string.text_rumah))
            intent.putExtra("ext_icon", R.drawable.ic_doa_rumah)
            startActivity(intent)
        }
        binding.cardDoaMakananMinuman.setOnClickListener {
            val intent = Intent(this, ListDoaActivity::class.java)
            intent.putExtra("ext_title", getString(R.string.text_makanan_amp_minuman))
            intent.putExtra("ext_icon", R.drawable.ic_doa_makanan_minuman)
            startActivity(intent)
        }
        binding.cardDoaPerjalanan.setOnClickListener {
            val intent = Intent(this, ListDoaActivity::class.java)
            intent.putExtra("ext_title", getString(R.string.text_perjalanan))
            intent.putExtra("ext_icon", R.drawable.ic_doa_perjalanan)
            startActivity(intent)
        }
        binding.cardDoaSholat.setOnClickListener {
            val intent = Intent(this, ListDoaActivity::class.java)
            intent.putExtra("ext_title", getString(R.string.text_sholat))
            intent.putExtra("ext_icon", R.drawable.ic_doa_sholat)
            startActivity(intent)
        }
        binding.cardDoaEtikaBaik.setOnClickListener {
            val intent = Intent(this, ListDoaActivity::class.java)
            intent.putExtra("ext_title", getString(R.string.text_etika_baik))
            intent.putExtra("ext_icon", R.drawable.ic_doa_etika_baik)
            startActivity(intent)
        }
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

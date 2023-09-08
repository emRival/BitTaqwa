package com.fachryff.dashboardislami.menus.jadwalsholat

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.fachryff.dashboardislami.R
import com.fachryff.dashboardislami.databinding.ActivityMenuJadwalSholatBinding
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

class MenuJadwalSholatActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMenuJadwalSholatBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuJadwalSholatBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(R.layout.activity_menu_jadwal_sholat)


        setSupportActionBar(binding.toolbarMenuJadwalSholat)
        initView()
    }

    private fun initView() {
        val c:Date = Calendar.getInstance().time
        val df =  SimpleDateFormat("E, dd MMM", Locale.getDefault())
        val formattedDate: String = df.format(c)
        binding.tvDatePray.text = formattedDate

        initGetDataJadwalSholat(c, "bogor")
    }

    private fun initGetDataJadwalSholat(date: Date, city: String) {
        val df = SimpleDateFormat("yyy-MM-dd", Locale.getDefault())
        val formattedDate : String = df.format(date)

        Toast.makeText(this@MenuJadwalSholatActivity, "${formattedDate}", Toast.LENGTH_SHORT).show()


        val client = AsyncHttpClient()
//        val url = "https://api.banghasan.com/sholat/format/json/jadwal/$city/$formattedDate"
        val url = "https://api.pray.zone/v2/times/day.json?city=&city&date=$formattedDate"
        client.get(url, object  : AsyncHttpResponseHandler(){
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?
            ) {
                binding.pbJadwalSholat.visibility = View.INVISIBLE
                val  response = responseBody?. let { String(it) }

                try {
                    val  responseObject = JSONObject(response)
                    val dataResult = responseObject.getJSONObject("results")
                    val dataDateTimeArray = dataResult.getJSONArray("datetime")
                    val dataObjectDateTime = dataDateTimeArray.getJSONObject(0)
                    val dataObjectTimes = dataObjectDateTime.getJSONObject("times")

                    binding.tvPrayTimeImsak.text = dataObjectTimes.getString("Imsak")
                    binding.tvPrayTimeSubuh.text = dataObjectTimes.getString("Fajr")
                    binding.tvPrayTimeSunrise.text = dataObjectTimes.getString("Sunrise")
                    binding.tvPrayTimeDzuhur.text = dataObjectTimes.getString("Dhuhr")
                    binding.tvPrayTimeAshar.text = dataObjectTimes.getString("Asr")
                    binding.tvPrayTimeMaghrib.text = dataObjectTimes.getString("maghrib")
                    binding.tvPrayTimeIsya.text = dataObjectTimes.getString("Isha")

                    val dataObjectLocation = dataResult.getJSONObject("location")
                    binding.tvLocation.text = dataObjectLocation.getString("city")


                } catch (e: Exception) {
                    Toast.makeText(this@MenuJadwalSholatActivity, e.message, Toast.LENGTH_SHORT)
                        .show()
                    e.printStackTrace()

                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?,
                error: Throwable?
            ) {
                binding.pbJadwalSholat.visibility = View.INVISIBLE
                val  errorMessage = when (statusCode){
                    401 -> "$statusCode : Bad Request"
                    403 -> "$statusCode : Forbidden"
                    404 -> "$statusCode : Not Found"
                    else -> "$statusCode : ${error?.message}"
            }
                Toast.makeText(this@MenuJadwalSholatActivity, errorMessage, Toast.LENGTH_SHORT)
                    .show()

        }

        })

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
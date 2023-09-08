package com.fachryff.dashboardislami.menus.videokajian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.fachryff.dashboardislami.R
import com.fachryff.dashboardislami.databinding.ActivityDetailVideoKajianBinding
import com.fachryff.dashboardislami.menus.videokajian.data.VideoKajianModel
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class DetailVideoKajianActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_VIDEO_KAJIAN = "extra video kajian"
    }
    private lateinit var binding:ActivityDetailVideoKajianBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailVideoKajianBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.toolbarDetailVideoKajian)

        val video =
            intent.getParcelableExtra<VideoKajianModel>(EXTRA_VIDEO_KAJIAN) as VideoKajianModel

        initView(video)
    }

    private fun initView(video: VideoKajianModel) {
        val youTubePlayerView:YouTubePlayerView = findViewById(R.id.player_video)
        lifecycle.addObserver(youTubePlayerView)

        youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(video.urlVideo, 0f)
            }
        })

        binding.tvChannel.text= video.channel
        binding.tvTitle.text = video.title
        binding.tvSpeaker.text = video.speaker
        binding.tvSummary.text = video.summary

        binding.ivShare.setOnClickListener {
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_TEXT , "Kajian dengan judul \"${video.title}\"dibawakan oleh\"${video.speaker}\" dan dari channel \"${video.channel} \" \n\n\n Link Video : https://www.youtbe.com/watch?v=${video.urlVideo}"
            )
            sendIntent.type = "text/plain"
            startActivity(sendIntent)
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

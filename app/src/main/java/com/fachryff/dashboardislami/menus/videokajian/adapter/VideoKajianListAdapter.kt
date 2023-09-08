package com.fachryff.dashboardislami.menus.videokajian.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fachryff.dashboardislami.R
import com.fachryff.dashboardislami.menus.videokajian.data.VideoKajianModel
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import com.fachryff.dashboardislami.menus.videokajian.DetailVideoKajianActivity
import jp.wasabeef.glide.transformations.BlurTransformation


class VideoKajianListAdapter (
    private val ListVideoKajian : ArrayList<VideoKajianModel>
        ):RecyclerView.Adapter<VideoKajianListAdapter.ListViewHolder>() {

    inner class ListViewHolder(ItemView : View) : RecyclerView.ViewHolder(ItemView) {
        var imgPhoto : ImageView = ItemView.findViewById(R.id.iv_item_photo)
        var tvChannel : TextView = ItemView.findViewById(R.id.tv_channel)
        var tvSpeaker : TextView = ItemView.findViewById(R.id.tv_channel)
        var tvTitle : TextView = ItemView.findViewById(R.id.tv_channel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view:View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_video_kajian, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val video = ListVideoKajian[position]
        holder.tvChannel.text = video.channel
        holder.tvSpeaker.text = video.speaker
        holder.tvTitle.text = video.title

        Glide.with(holder.itemView.context)
            .load(video.thumbnail)
            .apply(bitmapTransform(BlurTransformation(18, 1)))
            .into(holder.imgPhoto)

        holder.itemView.setOnClickListener{
            val intent = Intent(it.context, DetailVideoKajianActivity::class.java)
            intent.putExtra(DetailVideoKajianActivity.EXTRA_VIDEO_KAJIAN, video)
                it.context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return ListVideoKajian.size
    }
}

package com.fachryff.dashboardislami.dashboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fachryff.dashboardislami.R
import com.fachryff.dashboardislami.dashboard.model.InspirationModel

class InspirationListAdapter(
    private val ListInspiration:
    ArrayList<InspirationModel>
) :
    RecyclerView.Adapter<InspirationListAdapter.ListViewHolder>() {

    // class untuk mendaftarkan komponen pada layout dan memasukannya kedalam variable

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // variable imgPhoto berisi komponen Imageview pada layout item_row_inspiration.xml
        var imgPhoto: ImageView = itemView.findViewById(R.id.iv_item_photo)
    }

    // mendaftartkan tampilan atau layout untuk menampilkan data
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {

        // varible view beisi layout yang akan menampilkan data (item_row_inspiration)
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_inspiration, parent, false)
        return ListViewHolder(view)
    }


    // memasang data ke komponen layout
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        // memasukkan data berdasarkan posisinya ke dalam variable inspiration
        val inspiration = ListInspiration[position]

        Glide.with(holder.itemView.context)
            .load(inspiration.inspirationImage)
            .into(holder.imgPhoto)

    }

    // menentukan jumlah data yang ingin ditampilkan
    override fun getItemCount(): Int {
        return ListInspiration.size
    }
}

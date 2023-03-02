package com.example.ukl

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardViewTimAdapter (private val listTim: ArrayList<Tim>): RecyclerView.Adapter<CardViewTimAdapter.CardViewHolder>() {

    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvFrom: TextView = itemView.findViewById(R.id.tv_item_desk)
        var tvTrofi: TextView = itemView.findViewById(R.id.tv_item_trofi)
        var btnFav: Button = itemView.findViewById(R.id.btn_set_fav)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_cardview_tim, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val (name, from, trofi, photo) = listTim[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvFrom.text = from
        holder.tvTrofi.text = trofi

        holder.btnFav.setOnClickListener{
            Toast.makeText(holder.itemView.context, "Favorite " + listTim[position].name, Toast.LENGTH_SHORT).show()
        }

        holder.itemView.setOnClickListener{
            Toast.makeText(holder.itemView.context, "Kamu memilih " + listTim[position].name, Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int {
        return listTim.size
    }

}
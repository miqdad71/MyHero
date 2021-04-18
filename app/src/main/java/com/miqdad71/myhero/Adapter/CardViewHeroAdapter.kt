package com.miqdad71.myhero.Adapter

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
import com.miqdad71.myhero.Data.Hero
import com.miqdad71.myhero.R

class CardViewHeroAdapter(private val listHero: ArrayList<Hero>) :
    RecyclerView.Adapter<CardViewHeroAdapter.CardViewViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_cardview_hero, parent, false)
        return CardViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val hero = listHero[position]
        Glide.with(holder.itemView.context)
            .load(hero.photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)
        holder.tvName.text = hero.name
        holder.tvTimes.text = hero.times
        holder.btnDetail.setOnClickListener { onItemClickCallback.onItemClicked(listHero[holder.adapterPosition]) }
        holder.btnShare.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Share " + listHero[holder.adapterPosition].name,
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvTimes: TextView = itemView.findViewById(R.id.tv_item_times)
        var btnDetail: Button = itemView.findViewById(R.id.btn_set_detail)
        var btnShare: Button = itemView.findViewById(R.id.btn_set_share)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Hero)
    }
}
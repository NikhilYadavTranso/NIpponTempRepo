package com.example.nippon.view.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.nippon.R

class HomeGridAdapter(
    private val gridTextList: List<String>,
    private val gridImageList: List<Int>
) :RecyclerView.Adapter<HomeGridAdapter.HomeGridPagerViewHolder>(){
    class HomeGridPagerViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView){
        val gridItemText: TextView = itemView.findViewById(R.id.gridItemText)
        val gridItemImage: AppCompatImageView = itemView.findViewById(R.id.gridItemImage)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeGridAdapter.HomeGridPagerViewHolder {
       val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.home_grid_item,parent,false)
        return HomeGridPagerViewHolder((view))
    }

    override fun onBindViewHolder(holder: HomeGridAdapter.HomeGridPagerViewHolder, position: Int) {
        holder.gridItemText.text = gridTextList[position]
        holder.gridItemImage.setImageResource(gridImageList[position])
    }

    override fun getItemCount(): Int {
        return gridTextList.size
    }

}
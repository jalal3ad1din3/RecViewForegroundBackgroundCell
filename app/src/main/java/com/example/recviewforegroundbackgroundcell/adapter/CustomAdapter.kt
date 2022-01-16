package com.example.recviewforegroundbackgroundcell.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recviewforegroundbackgroundcell.R
import com.example.recviewforegroundbackgroundcell.model.Member

class CustomAdapter(val member: List<Member>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_item_layout,parent,false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member = member[position]
        if (holder is CustomViewHolder)
            holder.name.text = member.name
    }

    override fun getItemCount(): Int {
        return member.size
    }
    class CustomViewHolder(view: View):RecyclerView.ViewHolder(view){
        val front_side = view.findViewById<RelativeLayout>(R.id.view_frontside)
        val name = view.findViewById<TextView>(R.id.name)
    }
}
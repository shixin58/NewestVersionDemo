package com.yiche.example.newestversiondemo.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.yiche.example.newestversiondemo.R

import java.util.ArrayList

/**
 *
 * Created by shixin on 2018/3/6.
 */
class LieAdapter : RecyclerView.Adapter<LieAdapter.ViewHolder>() {
    private val countryList = ArrayList<String>()

    fun setList(list: List<String>?) {
        countryList.clear()
        if (list != null && !list.isEmpty()) {
            countryList.addAll(list)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_lie, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle.text = countryList[position]
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var tvTitle: TextView = itemView.findViewById(R.id.tv_title)
    }
}

package com.heisenburg.nested.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.heisenburg.nested.R
import com.heisenburg.nested.custom.model.Item
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_list.view.*
import kotlinx.android.synthetic.main.item_list.view.recyclerview

class ListAdapter(val context: Context): RecyclerView.Adapter<ListAdapter.Holder>() {

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    var data: ArrayList<Item> = ArrayList();

    fun setDataArray(data: ArrayList<Item>){
        this.data = data
        notifyDataSetChanged()
        Log.d("TAG", " occunt" + data.size)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View  =
            LayoutInflater.from(context).inflate(R.layout.item_list, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.recyclerview.layoutManager = LinearLayoutManager(context,
            RecyclerView.HORIZONTAL, false)
        holder.itemView.recyclerview.adapter = ViewAdapter(context, data.get(position))
        holder.itemView.recyclerview.isNestedScrollingEnabled = false
        Log.d("TAG", " bind " + position)
    }

}
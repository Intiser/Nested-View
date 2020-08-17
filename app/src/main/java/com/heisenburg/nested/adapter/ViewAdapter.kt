package com.heisenburg.nested.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.heisenburg.nested.R
import com.heisenburg.nested.custom.model.Item
import kotlinx.android.synthetic.main.item_scroll.view.*

class ViewAdapter(val context: Context, val item: Item): RecyclerView.Adapter<ViewAdapter.Holder>() {


    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View  =
            LayoutInflater.from(context).inflate(R.layout.item_scroll, null, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return item.seconds
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.text.text = "" + position
    }
}
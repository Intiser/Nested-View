package com.heisenburg.nested.custom

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.heisenburg.nested.adapter.ListAdapter
import com.heisenburg.nested.custom.model.Item

class Customized @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {
    var items: ArrayList<Item> = ArrayList()
    var adapterz: ListAdapter? = null

    init {
        Log.d("TAG", "mes : init")
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        this.layoutManager = LinearLayoutManager(context,
            VERTICAL, false)
        adapterz = ListAdapter(context)
        adapterz?.setDataArray(items)
        this.adapter = adapterz
        this.isNestedScrollingEnabled = true
    }

    public fun addItem(){
        items.add(Item(100, 0))
        adapterz?.setDataArray(items)
    }

    fun setProgress(progressPx: Int) {
        adapterz?.setProgress(progressPx)
    }
}
package com.heisenburg.nested.custom

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.heisenburg.nested.adapter.ListAdapter
import com.heisenburg.nested.adapter.ViewAdapter
import com.heisenburg.nested.custom.model.Item

class Row @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    var scroll:Int = 0
    var onScrollListener: OnScrollListener? = null;

    init {
        scroll = 0;
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        this.layoutManager = LinearLayoutManager(context,
            HORIZONTAL, false)
        this.adapter = ViewAdapter(context, Item(100, 0))
        this.isNestedScrollingEnabled = true
        this.addOnScrollListener(object: RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                scroll += dx
                onScrollListener?.onScrollProgress(scroll)
            }
        })

    }

    public interface OnScrollListener{
        fun onScrollProgress(progressPx: Int)
    }

}
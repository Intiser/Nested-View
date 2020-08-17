package com.heisenburg.nested

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.heisenburg.nested.adapter.ListAdapter
import com.heisenburg.nested.adapter.ViewAdapter
import com.heisenburg.nested.custom.Row
import com.heisenburg.nested.custom.model.Item
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_list.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        setupView()
    }

    private fun setupRecyclerView() {
        row.onScrollListener = object : Row.OnScrollListener {
            override fun onScrollProgress(progressPx: Int) {
                Log.d("TAG", " Progress " + progressPx)
                custom.setProgress(progressPx)
            }
        }
    }

    private fun setupView() {
        button.setOnClickListener {
            custom.addItem()
        }
    }

}
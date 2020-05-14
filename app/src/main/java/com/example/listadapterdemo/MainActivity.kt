package com.example.listadapterdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: RecyclerViewListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        adapter = RecyclerViewListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        var list = listOf("a","a","a","a","a","a","a","a","a","a","a")
        adapter.submitList(list)

        findViewById<Button>(R.id.add).setOnClickListener {
            list = listOf("b") + list
            adapter.submitList(list)
        }
        findViewById<Button>(R.id.less).setOnClickListener {
            list = list.subList(1, list.size)
            adapter.submitList(list)
        }
    }
}

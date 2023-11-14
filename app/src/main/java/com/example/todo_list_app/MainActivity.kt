package com.example.todo_list_app
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var context :Context =this;
        val recyclerview = findViewById<RecyclerView>(R.id.product_list_recycler_view)
        recyclerview.layoutManager = LinearLayoutManager(this)
        var data = ArrayList<ItemsViewModel>()
        val flowersList: List<String> = mutableListOf("Fowler", "Beck", "Evans","Lotus","Lotus1","Lotus2"
            ,"Lotus3","Lotus4","Lotus5","flower2","flower3")
        for (i in flowersList.indices) {
            data.add(ItemsViewModel(flowersList[i],"$i"))
        }
        val adapter = CustomAdapter(data,context)
        recyclerview.adapter = adapter

    }




}


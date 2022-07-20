package com.example.todoapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

//entity -> table
//dao -> queries
//database
class MainActivity : AppCompatActivity() {
    private lateinit var database: myDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = Room.databaseBuilder(
            applicationContext, myDatabase::class.java, "To_Do"
        ).build()
        add.setOnClickListener{
            val intent = Intent(this,CreateCard::class.java)
            startActivity(intent)
        }
        deleteAll.setOnClickListener{
            DataObject.deleteAll()
            setRecycler()

            GlobalScope.launch {
                database.dao().deleteAll()
            }
        }
        setRecycler()
    }
    fun setRecycler() {
        recycler_View.adapter = Adapter(DataObject.getAllData())
        recycler_View.layoutManager = LinearLayoutManager(this)
    }
}
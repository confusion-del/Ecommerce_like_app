package com.example.tradeapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class UsersActivity : AppCompatActivity() {

    var myListPeople: ListView? = null
    var items:ArrayList<Item>? = null
    var adapter:CustomAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)
        myListPeople = findViewById(R.id.mListpeople)
        items = ArrayList()
        adapter = CustomAdapter(this,items!!)
        var ref = FirebaseDatabase.getInstance().getReference().child("Users")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                items!!.clear()
                for (snap in snapshot.children){
                    var item = snap.getValue(Item::class.java)
                    items!!.add(item!!)
                }
                adapter!!.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@UsersActivity,
                    "DD Locked", Toast.LENGTH_LONG).show()
            }
        })
        myListPeople!!.adapter = adapter
    }
}
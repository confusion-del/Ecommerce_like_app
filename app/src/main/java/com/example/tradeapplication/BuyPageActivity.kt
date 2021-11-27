package com.example.tradeapplication

import android.content.Intent
import android.icu.lang.UProperty.NAME
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*

class BuyPageActivity : AppCompatActivity() {

    var itemsList: ListView? =null
    var items:ArrayList<Item>? =null
    var adapter:CustomAdapter? =null
    var btton:Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_page)

        itemsList = findViewById(R.id.mListItems)
        btton = findViewById(R.id.mBtn2)
        items = ArrayList()
        adapter = CustomAdapter(this,items!!)

        var item1 = Item(R.drawable.beach,"Car",
            "Ksh 2500000","This is a nice car")
        var item2 = Item(R.drawable.vehicle,"Car",
            "Ksh 5600000","This is a nice car")
        var item3 = Item(R.drawable.beach,"Car",
            "Ksh 5000000","This is a nice car")
        var item4 = Item(R.drawable.vehicle,"Car",
            "Ksh 6706000","This is a nice car")
        var item5 = Item(R.drawable.beach,"Car",
            "Ksh 5486000","This is a nice car")
        items!!.add(item1)
        items!!.add(item2)
        items!!.add(item3)
        items!!.add(item4)
        items!!.add(item5)
        itemsList!!.adapter = adapter





    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item,menu)

        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var item_id=item.itemId

        if (item_id==R.id.profile){
            Toast.makeText(this,"This is user profile item",
                Toast.LENGTH_LONG).show()
        }else if (item_id==R.id.setting){
            Toast.makeText(this,"This is settings item",
                Toast.LENGTH_LONG).show()
        }else if (item_id==R.id.help){
            Toast.makeText(this,"This is help item",
                Toast.LENGTH_LONG).show()
        }else if (item_id==R.id.share){
            Toast.makeText(this,"This is share item",
                Toast.LENGTH_LONG).show()
        }else if (item_id==R.id.exit){
            Toast.makeText(this,"This is share item",
                Toast.LENGTH_LONG).show()
        }

        return true
    }
}
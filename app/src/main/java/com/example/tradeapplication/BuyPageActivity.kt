package com.example.tradeapplication

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BuyPageActivity : AppCompatActivity() {

    var itemsList: ListView? =null
    var items:ArrayList<Item>? =null
    var adapter:CustomAdapter? =null
    var buttoncart:FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_page)


        itemsList = findViewById(R.id.mListItems)
        items = ArrayList()
        adapter = CustomAdapter(this,items!!)
        buttoncart = findViewById(R.id.Flt)

        var item1 = Item(R.drawable.beach,"Car",
            "Ksh 2,500,000","Silk white, twin turbo engine")
        var item2 = Item(R.drawable.vehicle,"Car",
            "Ksh 5,600,000","Lambo Urus")
        var item3 = Item(R.drawable.beach,"Car",
            "Ksh 5,000,000","LAmbo Vendetta")
        var item4 = Item(R.drawable.vehicle,"Car",
            "Ksh 6,706,000","Top speed 240mph")
        var item5 = Item(R.drawable.beach,"Car",
            "Ksh 5,486,000","360p hp")
        items!!.add(item1)
        items!!.add(item2)
        items!!.add(item3)
        items!!.add(item4)
        items!!.add(item5)
        itemsList!!.adapter = adapter

        buttoncart!!.setOnClickListener{
            startActivity(Intent(this,AddToCart::class.java))
        }


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


package com.example.tradeapplication

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    var cardBuy:CardView?= null
    var cardSell:CardView?= null
    var mAuth:FirebaseAuth? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cardBuy = findViewById(R.id.btn1)
        cardSell = findViewById(R.id.btn2)
        mAuth = FirebaseAuth.getInstance()


        cardBuy!!.setOnClickListener {
            var tembea1 = Intent(this,BuyPageActivity::class.java)
            startActivity(tembea1)
        }
        cardSell!!.setOnClickListener {
            var tembea2 = Intent(this,SellPageActivity::class.java)
            startActivity(tembea2)
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
            Toast.makeText(this,"This is exit item",
                Toast.LENGTH_LONG).show()
        }

        return true
    }

    override fun onStart() {
        super.onStart()
        var user = mAuth?.currentUser
        if (user==null){
            startActivity(Intent(this,LoginActivity::class.java))
        }

    }



}
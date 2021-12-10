package com.example.tradeapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AddToCart : AppCompatActivity() {

    var buttonnext: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_to_cart)

        buttonnext = findViewById(R.id.btnNext)

        buttonnext!!.setOnClickListener {
            startActivity(Intent(this,FinalOrderActivity::class.java))
        }

    }
}
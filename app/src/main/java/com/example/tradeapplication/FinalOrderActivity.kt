package com.example.tradeapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FinalOrderActivity : AppCompatActivity() {

    var editname: EditText?= null
    var editphone: EditText?= null
    var editaddress: EditText?= null
    var editcity: EditText?= null
    var btndeliver: Button?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_order)

        editname = findViewById(R.id.deliveryname)
        editphone = findViewById(R.id.deliverynumber)
        editaddress = findViewById(R.id.deliveryaddress)
        editcity = findViewById(R.id.deliverycity)
        btndeliver = findViewById(R.id.buttondeliver)


        btndeliver!!.setOnClickListener {
            Toast.makeText(this,"Item delivery confirmed",
                Toast.LENGTH_LONG).show()
        }

    }
}
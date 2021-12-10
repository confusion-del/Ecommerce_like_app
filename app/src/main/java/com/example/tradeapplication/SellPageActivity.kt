package com.example.tradeapplication

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase


class SellPageActivity : AppCompatActivity() {

    private lateinit var filepath : Uri
    var buttonSave: Button? = null
    var editTextName: EditText? = null
    var editTextDescription: EditText? = null
    var editTextPrice: EditText? = null
    var buttonView:Button? = null
    var image: ImageView? = null
    private var buttonChoose: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sell_page)

        buttonSave = findViewById(R.id.button2)
        buttonChoose = findViewById(R.id.button)
        buttonView = findViewById(R.id.button3)
        image = findViewById(R.id.imageView)

        buttonChoose!!.setOnClickListener {
            startFileChooser()
        }

        buttonSave!!.setOnClickListener {
            //start receiving what the user has written on the input fields
            var name = editTextName!!.text.toString().trim()
            var description = editTextDescription!!.text.toString().trim()
            var price = editTextPrice!!.text.toString().trim()
            //Check if the user is trying to submit empty fields
            if (name.isEmpty()){
                editTextName!!.error = "Please fill this input"
                editTextName!!.requestFocus()
            }else if (description.isEmpty()){
                editTextDescription!!.error = "Please fill this input"
                editTextDescription!!.requestFocus()
            }else if (price.isEmpty()){
                editTextPrice!!.error = "Please fill this input"
                editTextPrice!!.requestFocus()
            }else{
                //proceed to save the data
                var time = System.currentTimeMillis().toString()
                var ref = FirebaseDatabase.getInstance().reference.child("Users/$time")
                var dataBeingSaved = User(name,description,price,time)
                ref.setValue(dataBeingSaved).addOnCompleteListener { task->
                    if (task.isSuccessful){
                        Toast.makeText(this,"Item saved successfully",
                            Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this,"Item saving failed",
                            Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
        buttonView!!.setOnClickListener { startActivity(Intent(this,UsersActivity::class.java)) }
    }
    private fun startFileChooser() {
        var i = Intent()
        i.type = "image/*"
        i.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(i,"Choose Picture"),111)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==111 && resultCode == RESULT_OK && data != null) {
            filepath =  data.data!!
            val selectedImage: Uri = data.data ?: return
            val bitmap = BitmapFactory.decodeStream(contentResolver.openInputStream(selectedImage))
            image!!.setImageBitmap(bitmap)
            var pictureFlag = 1
        }
    }
}
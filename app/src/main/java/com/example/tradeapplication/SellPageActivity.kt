package com.example.tradeapplication

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
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
        editTextDescription= findViewById(R.id.mTvDesc)
        editTextName = findViewById(R.id.mTvName)
        editTextPrice = findViewById(R.id.mTvPrice)
        buttonChoose = findViewById(R.id.button)
        buttonView = findViewById(R.id.button3)
        image = findViewById(R.id.imageView)

        buttonChoose!!.setOnClickListener {
            startFileChooser()
        }

        buttonSave!!.setOnClickListener {


        }


        buttonView!!.setOnClickListener { startActivity(Intent(this,UsersActivity::class.java)) }
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
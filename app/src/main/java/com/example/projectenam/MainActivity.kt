package com.example.projectenam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textData=createPhoneData()
        rv_part.layoutManager=LinearLayoutManager(this)
        rv_part.setHasFixedSize(true)
        rv_part.adapter=ContactAdapter(textData,{phoneItem:PhoneData->phoneItemClicked(phoneItem)})
    }
    private fun phoneItemClicked(phoneItem:PhoneData){
        val showDetailActivityIntent= Intent(this, PhoneDetailActivity::class.java)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT,phoneItem.phone.toString())
        showDetailActivityIntent.putExtra(Intent.EXTRA_TITLE, phoneItem.contactName)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEMPLATE, phoneItem.email)
        startActivity(showDetailActivityIntent)
    }
    private fun createPhoneData():List<PhoneData>{
        val partList=ArrayList<PhoneData>()
        partList.add(PhoneData(933877,"Alpha", "alpha@yahoo.co.id"))
        partList.add(PhoneData(442134,"Bravo", "bravo@yahoo.co.id"))
        partList.add(PhoneData(756364,"Charlie", "charlie@yahoo.co.id"))
        return partList
    }
}

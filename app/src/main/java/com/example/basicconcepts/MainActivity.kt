package com.example.basicconcepts

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.payButton)
        val tipList = mutableListOf<TipModel>();

        val totalField: TextView = findViewById(R.id.totalField)
        val nameField: TextView = findViewById(R.id.nameField)
        val amountField: TextView = findViewById(R.id.amountField)
        totalField.text = "Total: Rs 0"
        var totalAmount: Double = 0.0

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        val listView = findViewById<RecyclerView>(R.id.tip_recycler_view)
        val tipListAdapter = TipListAdapter(this, tipList);

        listView.layoutManager = layoutManager
        listView.adapter = tipListAdapter

        button.setOnClickListener {
            Toast.makeText(this, "${nameField.text} paid ${amountField.text}INR", Toast.LENGTH_SHORT).show()
            totalAmount += amountField.text.toString().toDouble()
            totalField.text = "Total: Rs ${totalAmount}"
            tipList.add(TipModel(nameField.text.toString(), amountField.text.toString().toDouble()))
            tipListAdapter.notifyDataSetChanged();
        }



    }
//    fun payHandler(){
//        val txtView: TextView = TextView(this);
//        txtView.setText("${nameField.text} paid ${amountField.text}INR")
//        txtView.setTextSize(18F)
//        txtView.setTextColor(Color.GREEN)
//        val toast = Toast(applicationContext)
//            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 1000)
//        toast.duration = Toast.LENGTH_LONG
//        toast.setView(txtView)
//        toast.show()
//    }

}
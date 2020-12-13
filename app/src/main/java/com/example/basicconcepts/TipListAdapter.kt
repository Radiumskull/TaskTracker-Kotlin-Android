package com.example.basicconcepts

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TipListAdapter(val context: Context, val tipList: List<TipModel>): RecyclerView.Adapter<TipListAdapter.TipViewHolder>() {
    class TipViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun setData(data: TipModel){
            val donorName = itemView.findViewById<TextView>(R.id.tip_donor_name)
            val donationAmount = itemView.findViewById<TextView>(R.id.tip_donation_amount)
            val donorImage = itemView.findViewById<ImageView>(R.id.donor_image)
            donorImage.setImageResource(R.drawable.male_avatar)
            donorName.text = data.name
            donationAmount.text = "Rs. ${data.amount.toString()}"
            when{
                data.amount < 500.0 -> {
                    donorName.setTextColor(Color.RED)
                    donationAmount.setTextColor(Color.RED)
                }
                data.amount > 2000.0 -> {
                    donorName.setTextColor(Color.GREEN)
                    donationAmount.setTextColor(Color.GREEN)
                }
                else -> {
                    donorName.setTextColor(Color.YELLOW)
                    donationAmount.setTextColor(Color.YELLOW)
                }
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipListAdapter.TipViewHolder {
//        val txtView: TextView = TextView(context)
        val view = LayoutInflater.from(context).inflate(R.layout.tip_item_layout, parent, false);
        return TipViewHolder(view)
    }

    override fun getItemCount(): Int { return tipList.size }


    override fun onBindViewHolder(holder: TipListAdapter.TipViewHolder, position: Int) {
        holder.setData(tipList[position] as TipModel)
    }

}
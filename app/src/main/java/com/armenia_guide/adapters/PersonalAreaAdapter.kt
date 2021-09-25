package com.armenia_guide.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.armenia_guide.R
import com.armenia_guide.ui.personal_area.ModelPersonalArea

class PersonalAreaAdapter(val context: Context, private val listPersonalArea: List<ModelPersonalArea>) :
    Adapter<PersonalAreaAdapter.ViewHolderPersonalArea>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPersonalArea {
        val view = LayoutInflater.from(context).inflate(R.layout.personal_area_recycler_row, parent, false)
        return ViewHolderPersonalArea(view)
    }

    override fun onBindViewHolder(holder: ViewHolderPersonalArea, position: Int) {

        holder.image.setImageResource(listPersonalArea[position].image)
        holder.titleText.text = listPersonalArea[position].title
        holder.timeText.text = listPersonalArea[position].time
        holder.priceText.text = listPersonalArea[position].price


    }


    override fun getItemCount(): Int {
        return listPersonalArea.size
    }


    class ViewHolderPersonalArea(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.image)
        val titleText = view.findViewById<TextView>(R.id.title)
        val timeText = view.findViewById<TextView>(R.id.time)
        val priceText = view.findViewById<TextView>(R.id.price)

    }
}
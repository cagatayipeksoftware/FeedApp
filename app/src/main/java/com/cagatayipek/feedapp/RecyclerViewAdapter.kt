package com.cagatayipek.feedapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cagatayipek.feedapp.databinding.FragmentLoginmenuBinding
import kotlinx.android.synthetic.main.row_layout.view.*

class RecyclerViewAdapter(private val foodModels:ArrayList<FoodModel>):RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {
    class RowHolder(view:View):RecyclerView.ViewHolder(view) {
        fun bind(foodModel: FoodModel){
            itemView.mealname.text=foodModel.name

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.row_layout,parent,false)
        return RowHolder(view)
    }

    override fun getItemCount(): Int {
        return foodModels.count()
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(foodModels[position])
    }
}
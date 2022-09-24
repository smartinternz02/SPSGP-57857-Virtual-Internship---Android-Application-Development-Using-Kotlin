package com.example.grocerryapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GroceryAdapter(var list: List<GroceryItems>, val groceryItemClickInterface : GroceryItemClickInterface) :
    RecyclerView.Adapter<GroceryAdapter.GroceryViewHolder>() {

    // In this function we will add our groceryadapter.xml to kotlin class
    inner class GroceryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nameTV =itemView.findViewById<TextView>(R.id.TVItemName)
        val quantityTV =itemView.findViewById<TextView>(R.id.TVQuantity)
        val rateTV =itemView.findViewById<TextView>(R.id.TVRate)
        val amountTV =itemView.findViewById<TextView>(R.id.TVTotalAmount)
        val deleteIV =itemView.findViewById<ImageView>(R.id.idIVDelete)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grocery_rv_item, parent, false)
        return GroceryViewHolder(view)
    }

    // This function is used to return total number of size of list.
    override fun getItemCount(): Int {
        return list.size
    }

    // In onBindViewHolder we will bind our itemViews with adapter
    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {

        holder.nameTV.text = list.get(position).itemName
        holder.quantityTV.text = list.get(position).itemQuantity.toString()
        holder.rateTV.text="Rs. "+list.get(position).itemPrice.toString()

        val itemTotal:Int =list.get(position).itemPrice * list.get(position).itemQuantity
        holder.amountTV.text= "Rs. "+itemTotal.toString()

        holder.deleteIV.setOnClickListener {
            groceryItemClickInterface.onItemClick(list.get(position))
        }

        // To get total cost
//        if (position == list.size - 1) {
//            var totalCost = 0
//            for (i in 0 until list.size) {
//                totalCost += list[i].itemPrice
//            }
//            holder.itemView.txtItemTotalCost.visibility = View.VISIBLE
//            holder.itemView.txtTotalCostTitle.visibility = View.VISIBLE
//            holder.itemView.txtItemTotalCost.text = "$totalCost"
//        }
    }
    // Inner class for viewHolder

    interface GroceryItemClickInterface{
        fun onItemClick(groceryItems:GroceryItems)
    }
}
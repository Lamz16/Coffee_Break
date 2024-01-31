package com.lamz.coffeebreak.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lamz.coffeebreak.databinding.ItemRowBinding
import com.lamz.coffeebreak.dummy.ContentPopular

class MenuAdapter(private val listMenu : ArrayList<ContentPopular>) : RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

    private lateinit var itemClick : ItemClicked
    class ViewHolder(var binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root)

    fun setOnItemClickCallback(itemClick: ItemClicked) {
        this.itemClick = itemClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int =listMenu.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (name, price, images) = listMenu[position]
        holder.binding.menuId.setImageResource(images)
        holder.binding.menuName.text = name
        holder.binding.price.text = price

        holder.itemView.setOnClickListener {

        }
    }

    interface ItemClicked{
        fun onClicked(data: ContentPopular)
    }
}
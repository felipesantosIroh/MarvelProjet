package com.irohouse.chibatascomics.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.irohouse.chibatascomics.databinding.ListCreatorBinding
import com.irohouse.chibatascomics.model.creator.Item

class ListCreatorAdapter(private val creatorItems: List<Item>) :
    RecyclerView.Adapter<ListCreatorAdapter.CreatorViewHolder>() {


    class CreatorViewHolder(private val binding: ListCreatorBinding) :
        RecyclerView.ViewHolder(binding.root){
        fun bind(creatorItems: Item) = with(binding){
            textRoleCreator.text = creatorItems.role
            textNameCreator.text = creatorItems.name
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CreatorViewHolder {
        val binding = ListCreatorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CreatorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CreatorViewHolder, position: Int) {
        holder.bind(creatorItems[position])
    }

    override fun getItemCount(): Int {
        return creatorItems.size
    }
}
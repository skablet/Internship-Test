package com.diakonov.internship.screens.mainInfo

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diakonov.internship.model.main.MainItem
import com.diakonov.internshiptest.databinding.ItemAnimalLayoutBinding
import com.squareup.picasso.Picasso

class MainAdapter: RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    var listMain = emptyList<MainItem>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = ItemAnimalLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val mainItem : MainItem = listMain[position]


        holder.bind(mainItem)

    }

    override fun getItemCount(): Int {
        return listMain.size

    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<MainItem>){
        listMain = list
        notifyDataSetChanged()
    }

    class MainViewHolder(private val binding: ItemAnimalLayoutBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun bind(mainItem: MainItem){

            binding.tvName.text = mainItem.name
            binding.tvHab.text = mainItem.habitat
            binding.tvTime.text = mainItem.active_time
            Picasso.get().load(mainItem.image_link).into(binding.imAnimal)

        }
    }


}
package com.diakonov.internshiptest

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diakonov.internshiptest.databinding.StudentInfoLayoutBinding
import com.diakonov.internshiptest.db.model.UserModel

class UserInfoAdapter(): RecyclerView.Adapter<UserInfoAdapter.UserInfoViewHolder>() {

    

    var listUser = emptyList<UserModel>()
    lateinit var binding: StudentInfoLayoutBinding



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserInfoViewHolder{
        binding = StudentInfoLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
       // binding.cbStatus.setOnCheckedChangeListener{}

        return UserInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserInfoViewHolder, position: Int) {
        val user : UserModel = listUser[position]
        binding.tvName.text = listUser[position].name
        binding.tvAge.text = listUser[position].age.toString()
        binding.cbStatus.isChecked = listUser[position].isStudent
       
        holder.bind(user)
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<UserModel>){
        listUser = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: UserInfoViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener(){




        }
    }

    override fun onViewDetachedFromWindow(holder: UserInfoViewHolder) {
        holder.itemView.setOnClickListener(null)
    }

    class UserInfoViewHolder(private val binding: StudentInfoLayoutBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun bind(user: UserModel){
            binding.tvName.text = user.name
            binding.tvAge.text = user.age.toString()
            binding.cbStatus.isChecked = user.isStudent

        }
    }




}


//data class User(val name: String, val age: Int)
//var First = User("First Student", 16)
//var Second = User("Second Student", 17)
//var Third = User("Third Student", 18)
//var Fourth = User("Fourth Student", 19)
//var Fifth = User("Fifth Student", 21)
//var Sixth = User("Sixth Student", 22)
//var Seventh = User("Seventh Student", 19)



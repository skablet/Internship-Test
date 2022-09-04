package com.diakonov.internshiptest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diakonov.internshiptest.databinding.StudentInfoLayoutBinding

class UserInfoAdapter: RecyclerView.Adapter<UserInfoAdapter.UserInfoHolder>() {

    private lateinit var mListener : OnItemClickListener

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        mListener = listener
    }


    val userList = listOf(First, Second, Third, Fourth, Fifth, Sixth, Seventh)

    class UserInfoHolder(item: View, listener : OnItemClickListener): RecyclerView.ViewHolder(item) {

        private val binding = StudentInfoLayoutBinding.bind(item)
        fun bind(user: User) = with(binding){
            tvName.text = user.name
            tvAge.text = user.age.toString()
            cbStatus.isChecked = user.isStudent
            cbStatus.setOnClickListener{
                user.isStudent = cbStatus.isChecked}
            }
        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserInfoHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_info_layout, parent, false)
        return UserInfoHolder(view, mListener)
    }

    override fun onBindViewHolder(holder: UserInfoHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }


}
data class User(val name: String, val age: Int, var isStudent: Boolean = false)
var First = User("First Student", 16)
var Second = User("Second Student", 17)
var Third = User("Third Student", 18)
var Fourth = User("Fourth Student", 19)
var Fifth = User("Fifth Student", 21)
var Sixth = User("Sixth Student", 22)
var Seventh = User("Seventh Student", 19)



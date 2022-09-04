package com.diakonov.internshiptest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.diakonov.internshiptest.databinding.ActivityMain2Binding

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: UserInfoAdapter
    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }


    private fun init(){
        recyclerView = binding.rvInfo
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = UserInfoAdapter()
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : UserInfoAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {
                val bundle = Bundle()
                bundle.putString("name", adapter.userList[position].name)
                bundle.putString("age", adapter.userList[position].age.toString() )
                bundle.putBoolean("status", adapter.userList[position].isStudent )
                val fragmentA = InfoFragment()
                fragmentA.arguments = bundle
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame, fragmentA)
                    .commit()
            }

        })
    }
}


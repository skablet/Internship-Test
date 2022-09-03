package com.diakonov.internshiptest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.diakonov.internshiptest.databinding.ActivityMain2Binding
import com.diakonov.internshiptest.db.model.UserModel
import com.diakonov.internshiptest.db.repo.UserRepo

lateinit var REPOSITORY: UserRepo

class MainActivity : AppCompatActivity(), UserInfoAdapter.OnRecyclerViewItemClickListener{

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: UserInfoAdapter
    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        init()

        fun itemClick(userModel: UserModel){
            val bundle = Bundle()
            bundle.putSerializable("user", userModel)
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame, InfoFragment.newInstance())
                .commit()
            }

    }
    private fun init() {
        val viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        viewModel.initDatabase()
        recyclerView = binding.rvInfo
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = UserInfoAdapter()
        recyclerView.adapter = adapter
        viewModel.getAllUsers().observe(this) { listUsers ->
            adapter.setList(listUsers.asReversed()) }
//        adapter.binding.cbStatus.setOnCheckedChangeListener{
//            val checkStatus = adapter.binding.cbStatus.isChecked
//            viewModel.update(UserModel(isStudent = checkStatus))}

        binding.toolbar.inflateMenu(R.menu.fragm_menu)
        binding.toolbar.title = "Add New User"
        binding.toolbar.setNavigationIcon(R.drawable.add_icon)
        binding.toolbar.setNavigationOnClickListener{
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame, AddUserFragment.newInstance())
                .commit()
        }
    }
    companion object{
        fun itemClick(userModel: UserModel){
            val bundle = Bundle()
            bundle.putSerializable("user", userModel)





        }
    }


}


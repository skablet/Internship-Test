package com.diakonov.internship.screens.mainInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.diakonov.internshiptest.databinding.FragmentMainInfoBinding

class MainInfoFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MainAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        val viewModel = ViewModelProvider(this).get(MainInfoViewModel::class.java)
        val bindingMainFragment = FragmentMainInfoBinding.inflate(inflater)

        recyclerView = bindingMainFragment.rvMain
        adapter = MainAdapter()
        recyclerView.adapter = adapter


        viewModel.getAnimals()
        viewModel.animalList.observe(viewLifecycleOwner) { list ->
            list.body()?.let { adapter.setList(it)}}

        return bindingMainFragment.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainInfoFragment()
    }
}

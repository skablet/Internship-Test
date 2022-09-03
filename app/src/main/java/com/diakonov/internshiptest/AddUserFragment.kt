package com.diakonov.internshiptest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.diakonov.internshiptest.databinding.FragmentAddUserBinding
import com.diakonov.internshiptest.db.model.UserModel


class AddUserFragment : Fragment() {
    lateinit var bindingAddFrag: FragmentAddUserBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        bindingAddFrag = FragmentAddUserBinding.inflate(inflater)
        return bindingAddFrag.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        val viewModel = ViewModelProvider(this).get(AddUserViewModel::class.java)
        bindingAddFrag.saveBtn.setOnClickListener{
            val userName = bindingAddFrag.addName.text.toString()
            val userAge = bindingAddFrag.addAge.text.toString()
            viewModel.insert(UserModel(name = userName, age = userAge, isStudent = false)){}
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.remove(this)
                ?.commit()
            Toast.makeText(context, "User added successfully", Toast.LENGTH_SHORT).show()
        }

        bindingAddFrag.backBtn.setOnClickListener{activity?.supportFragmentManager
            ?.beginTransaction()
            ?.remove(this)
            ?.commit()
        }
        bindingAddFrag
    }



    companion object {
       @JvmStatic
        fun newInstance() = AddUserFragment()
}
}

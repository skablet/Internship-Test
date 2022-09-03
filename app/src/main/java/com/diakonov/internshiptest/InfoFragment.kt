package com.diakonov.internshiptest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.diakonov.internshiptest.databinding.FragmentInfoBinding
import com.diakonov.internshiptest.db.model.UserModel


class InfoFragment : Fragment() {

    lateinit var bindingInfoFrag: FragmentInfoBinding
    lateinit var currentUser: UserModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        bindingInfoFrag = FragmentInfoBinding.inflate(inflater)
//        currentUser = arguments?.getSerializable("user") as UserModel



        return bindingInfoFrag.root
    }

    private fun init(){
        bindingInfoFrag.fTvName.text = currentUser.name
        bindingInfoFrag.fTvAge.text = currentUser.age
        bindingInfoFrag.fCbStatus.isChecked = currentUser.isStudent

        bindingInfoFrag.toolBar.inflateMenu(R.menu.fragm_menu)
        bindingInfoFrag.toolBar.title = "Info Fragment"
        bindingInfoFrag.toolBar.setNavigationIcon(R.drawable.back_arrow)
        bindingInfoFrag.toolBar.setNavigationOnClickListener {activity
            ?.supportFragmentManager
            ?.beginTransaction()
            ?.remove(this)
            ?.commit()  }

    }








    companion object {
        @JvmStatic
        fun newInstance() = InfoFragment()
    }
}

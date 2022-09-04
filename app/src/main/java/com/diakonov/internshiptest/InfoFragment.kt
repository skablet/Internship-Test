package com.diakonov.internshiptest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.diakonov.internshiptest.databinding.FragmentInfoBinding


class InfoFragment : Fragment() {

   lateinit var bindingInfoFrag: FragmentInfoBinding

   override fun onCreateView(
       inflater: LayoutInflater, container: ViewGroup?,
       savedInstanceState: Bundle?,
   ): View {
       bindingInfoFrag = FragmentInfoBinding.inflate(inflater)
       init()
       bindingInfoFrag.fTvName.text = arguments?.getString("name")
       bindingInfoFrag.fTvAge.text = arguments?.getString("age")
       bindingInfoFrag.fCbStatus.isChecked = arguments?.getBoolean("status")!!
       return bindingInfoFrag.root
   }

   private fun init(){
       bindingInfoFrag.toolBar.inflateMenu(R.menu.fragm_menu)
       bindingInfoFrag.toolBar.title = "Info Fragment"
       bindingInfoFrag.toolBar.setNavigationIcon(R.drawable.back_arrow)
       bindingInfoFrag.toolBar.setNavigationOnClickListener {
           activity
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

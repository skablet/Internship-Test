package com.diakonov.internshiptest

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.view.MenuProvider
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.diakonov.internshiptest.databinding.FragmentCounterBinding


class CounterFragment : Fragment() {
    private val dataModel by activityViewModels<DataModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val binding = FragmentCounterBinding.inflate(inflater)

        binding.bCounter.setOnClickListener {dataModel.increment()}


        dataModel.score.observe(activity as LifecycleOwner) {
            binding.currentScore.text = it.countValue.toString()
        }









        binding.toolBar.inflateMenu(R.menu.frag_menu)
        binding.toolBar.title = "Counter Fragment"
        binding.toolBar.setNavigationIcon(R.drawable.back_arrow)
        binding.toolBar.setNavigationOnClickListener {activity
            ?.supportFragmentManager
            ?.beginTransaction()
            ?.remove(this)
            ?.commit()  }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = CounterFragment()
    }


}
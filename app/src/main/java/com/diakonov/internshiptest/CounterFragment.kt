package com.diakonov.internshiptest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.diakonov.internshiptest.databinding.FragmentCounterBinding


class CounterFragment : Fragment() {
    private val dataModel by activityViewModels<DataModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
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
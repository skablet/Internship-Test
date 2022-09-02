package com.diakonov.internshiptest

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.diakonov.internshiptest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(dataModel.score.value == null) {
            dataModel.initState(DataModel.Score(0))
        }
        dataModel.score.observe(this) { binding.score.text = it.countValue.toString() }

        binding.bToFrag.setOnClickListener(){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame, CounterFragment())
                .commit()
        }
    }
}


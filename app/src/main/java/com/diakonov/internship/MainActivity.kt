package com.diakonov.internship

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.diakonov.internship.screens.mainInfo.MainInfoFragment
import com.diakonov.internshiptest.R
import com.diakonov.internshiptest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame, MainInfoFragment())
            .commit()
    }
}
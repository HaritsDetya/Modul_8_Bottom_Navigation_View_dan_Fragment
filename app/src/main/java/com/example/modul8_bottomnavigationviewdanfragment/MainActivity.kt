package com.example.modul8_bottomnavigationviewdanfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.modul8_bottomnavigationviewdanfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
            val navController = findNavController(R.id.navHostFragment)
            bottomNavigationView.setupWithNavController(navController)
        }
    }
}
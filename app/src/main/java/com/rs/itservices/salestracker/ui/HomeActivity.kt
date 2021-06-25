package com.rs.itservices.salestracker.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rs.itservices.salestracker.databinding.ActivityHomeBinding

/**
 * created by **lovepreetkaur240@gmail.com** 25June,2021
 */

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
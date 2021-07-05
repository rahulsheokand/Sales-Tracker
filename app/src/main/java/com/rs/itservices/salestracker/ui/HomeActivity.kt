package com.rs.itservices.salestracker.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.rs.itservices.salestracker.R
import com.rs.itservices.salestracker.databinding.ActivityHomeBinding
import com.rs.itservices.salestracker.ui.webprocess.WebActivity


/**
 * created by **lovepreetkaur240@gmail.com** 25June,2021
 */

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var img_back: ImageView = findViewById(R.id.img_back)
        img_back.setOnClickListener {
            onBackPressed()
        }

        binding.tvNewAccount.setOnClickListener{
            startActivity(Intent(this,WebActivity::class.java))
        }
        binding.tvNewLead.setOnClickListener{
            startActivity(Intent(this,WebActivity::class.java))
        }
    }
}
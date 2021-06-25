package co.e.io.sales.tracker.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import co.e.io.sales.tracker.databinding.ActivityHomeBinding

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
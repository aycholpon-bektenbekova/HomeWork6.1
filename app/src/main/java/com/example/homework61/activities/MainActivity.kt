package com.example.homework61.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.homework61.R
import com.example.homework61.contracts.SecondActivityContract
import com.example.homework61.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val getResult = registerForActivityResult(SecondActivityContract()) { result ->}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClicker()
    }

    private fun initClicker() {
        with(binding){
            btnFirst.setOnClickListener {
                if (etFirst.text.isEmpty()) {
                    Toast.makeText(
                        this@MainActivity, getString(R.string.empty_text),
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                   getResult.launch(binding.etFirst.text.toString())
                }
            }
        }
    }
}
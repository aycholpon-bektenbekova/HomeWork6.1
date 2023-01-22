package com.example.homework61.activities

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.homework61.R
import com.example.homework61.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            btnSecond.setOnClickListener {
                if (binding.etSecond.text.isEmpty()) {
                    Toast.makeText(
                        this@SecondActivity, getString(R.string.empty_text),
                        Toast.LENGTH_LONG).show()
                } else {
                    setResult(Activity.RESULT_OK)
                    finish()
                }
            }
        }
    }
}
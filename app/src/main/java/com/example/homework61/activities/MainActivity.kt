package com.example.homework61.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.homework61.R
import com.example.homework61.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var getResult: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initLauncher()
        initClicker()
    }

    private fun initLauncher() {
        getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK){
                binding.etFirst.setText(result.data?.getStringExtra(KEY))
            }
        }
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
                   Intent(this@MainActivity, SecondActivity::class.java).apply{
                       putExtra(KEY, etFirst.text)
                       getResult.launch(this)
                   }
                }
            }
        }
    }

    companion object{
        const val KEY = "key for intent"
    }
}
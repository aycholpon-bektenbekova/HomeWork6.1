package com.example.homework61.contracts

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.example.homework61.activities.SecondActivity

class SecondActivityContract : ActivityResultContract<String, Int?>() {
    override fun createIntent(context: Context, input: String): Intent {
        return Intent(context, SecondActivity::class.java)
            .putExtra("my_input_key", input)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): Int? = when{
        resultCode != Activity.RESULT_OK -> null
        else -> intent?.getIntExtra("my_result_key", 42)
    }

}
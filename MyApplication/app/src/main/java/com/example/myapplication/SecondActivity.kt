package com.example.myapplication

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivitySecondBinding

class SecondActivity:  AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_second)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("main second", "in second activity create")


        var bundle : Bundle ? = intent.extras
        var msg = bundle!!.getString("user_message")
        Toast.makeText(this, "get message:$msg", Toast.LENGTH_SHORT).show()

        binding.textView2.text = msg

    }
}
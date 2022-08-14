package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)

        Log.i("main activity:", "onCreate up")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button2.setOnClickListener{
            Log.i("main activity", "button 2 clicked")
            Toast.makeText(this, "button clicked.", Toast.LENGTH_SHORT).show()
        }
        var progressDialog  = binding.progressBarID
        progressDialog.visibility = View.GONE

        binding.button3.setOnClickListener {
            Log.d("main acitivity", "button 3 clicked")

            Toast.makeText(this, "try to make progress bar toggle", Toast.LENGTH_SHORT).show()

            // progressBar tutorial refer: https://tutorialwing.com/android-progressbar-using-kotlin-with-example/
            progressDialog.visibility =  if (progressDialog.visibility == View.GONE) View.VISIBLE else View.GONE


            var message: String = binding.editUserMessage.text.toString()

            var intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("user_message", message)
            startActivity(intent)
        }

        binding.button.setOnClickListener {
            Log.d("main activity", "button next clicked")
            Toast.makeText(this, "go next", Toast.LENGTH_SHORT).show()
        }



    }
}
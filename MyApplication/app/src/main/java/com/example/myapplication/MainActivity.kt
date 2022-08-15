package com.example.myapplication

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var alertDialog:AlertDialog ? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)

        Log.i("main activity:", "onCreate up")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var builder = AlertDialog.Builder(this)

        var progressDialog  = binding.progressBarID
        progressDialog.visibility =  View.VISIBLE //View.GONE

        binding.button3.setOnClickListener {
            Log.d("main acitivity", "button 3 clicked")

            Toast.makeText(this, "try to make progress bar toggle", Toast.LENGTH_SHORT).show()

            // progressBar tutorial refer: https://tutorialwing.com/android-progressbar-using-kotlin-with-example/
            progressDialog.visibility =  if (progressDialog.visibility == View.GONE) View.VISIBLE else View.GONE


        }

        binding.button.setOnClickListener {
            Log.d("main activity", "button next clicked")
            Toast.makeText(this, "go next", Toast.LENGTH_SHORT).show()

            var message: String = binding.editUserMessage.text.toString()

            var intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("user_message", message)
            startActivity(intent)
        }

        // simple yes / no dialog
        binding.button2.setOnClickListener {

            // ERROR: E/WindowManager: android.view.WindowLeaked:
            //     Activity com.example.myapplication.MainActivity has leaked window
            Toast.makeText(this, "show dialog", Toast.LENGTH_SHORT).show()
            builder.setTitle("title")
            builder.setMessage("message here")
            builder.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, id ->
                Toast.makeText(this, "Yes clicked", Toast.LENGTH_SHORT).show()
                dialog.cancel()
            })
            builder.setNegativeButton("No", DialogInterface.OnClickListener{ dialog, id ->
                Toast.makeText(this, "No clicked", Toast.LENGTH_SHORT).show()
                dialog.cancel()
            })

            // can only be canceled by calling dialog.cancel(),
            // if not set, user can touch other area to cancel.
            builder.setCancelable(false)

            var alert :AlertDialog = builder.create()
            alert.show()
            alertDialog = alert
        }


    }

    override fun onDestroy() {
        if (alertDialog?.isShowing() == true) {
            alertDialog?.cancel()
        }
        super.onDestroy()
    }
}
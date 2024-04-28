package com.example.kotlinpractice

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.kotlinpractice.R.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        Log.i("MYTAG","MainActivity : OnCreate")
        val greetingTextView = findViewById<TextView>(id.tvHello)
        val inputField = findViewById<EditText>(id.etName)
        val submitButton = findViewById<Button>(id.btnSubmit)
        val offersButton = findViewById<Button>(id.btnOffers)
        var enteredName = ""
        submitButton.setOnClickListener{
             enteredName = inputField.text.toString()
            if (enteredName == ""){
                offersButton.visibility = INVISIBLE
                greetingTextView.text = ""
                Toast.makeText(this@MainActivity, "Please enter your name!", Toast.LENGTH_SHORT).show()
            }
            else {
                val message = "Welcome $enteredName!"
                greetingTextView.text = message
                inputField.text.clear()
                offersButton.visibility = VISIBLE
            }
        }
        offersButton.setOnClickListener{
            val intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("USER",enteredName)
            startActivity(intent)
        }
    }






  /*  override fun onStart()
    {
        super.onStart()
        Log.i("MYTAG","MainActivity : OnStart")
    }

    override fun onResume()
    {
        super.onResume()
        Log.i("MYTAG","MainActivity : OnResume")
    }

    override fun onPause()
    {
        super.onPause()
        Log.i("MYTAG","MainActivity : OnPause")
    }

    override fun onStop()
    {
        super.onStop()
        Log.i("MYTAG","MainActivity : OnStop")
    }

    override fun onDestroy()
    {
        super.onDestroy()
        Log.i("MYTAG","MainActivity : OnDestroy")
    }

    override fun onRestart()
    {
        super.onRestart()
        Log.i("MYTAG","MainActivity : OnRestart")
    }  */
}
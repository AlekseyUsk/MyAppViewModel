package com.hfad.myappviewmodel


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this,Factory(application,"Я передал при помощи фабрики во вью модель текст - ПРИВЕТ!!!")).get(MainViewModel::class.java)


        textView = findViewById(R.id.textView)
    }

    override fun onStart() {
        super.onStart()
        viewModel.liveData.observe(this, Observer {
            it
            textView.text = it
        })
    }


}
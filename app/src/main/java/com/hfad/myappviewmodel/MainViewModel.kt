package com.hfad.myappviewmodel

import android.app.Application
import android.os.CountDownTimer
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(application : Application,val text: String) : AndroidViewModel(application) {
    //val text: String - ПЕРЕДАТЬ В ПАРАМЕТРЫ КАКОЙ ТО ТЕКСТ

    val liveData = MutableLiveData<String>()

    init {
        startTimer()
    }
    fun startTimer(){
        object : CountDownTimer(15000,1000){
            override fun onTick(p0: Long) {
               liveData.value = ((p0/1000).toString())
            }
            override fun onFinish() {
                Toast.makeText(getApplication(),text,Toast.LENGTH_LONG).show()
                    //ВЫВЕСТИ К ПРИМЕРУ ТОСТ С ЭТИМ ТЕКСТОМ
                    // override fun onCreate(savedInstanceState: Bundle?) {
                //        super.onCreate(savedInstanceState)
                //        setContentView(R.layout.activity_main)
                //        viewModel = ViewModelProvider(this,Factory(application,"Я передал при помощи фабрики во вью модель текст - ПРИВЕТ!!!")).get(MainViewModel::class.java)
            }
        }.start()
    }
}
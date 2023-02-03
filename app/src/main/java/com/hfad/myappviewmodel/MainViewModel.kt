package com.hfad.myappviewmodel

import android.app.Application
import android.os.CountDownTimer
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(application : Application) : AndroidViewModel(application) {

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
                Toast.makeText(getApplication(),"Тут применена AndroidViewModel у которой есть контекст",Toast.LENGTH_LONG).show()
            }
        }.start()
    }
}
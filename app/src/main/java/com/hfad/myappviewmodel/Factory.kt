package com.hfad.myappviewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class Factory(val application: Application, val text: String) : ViewModelProvider.AndroidViewModelFactory(application) {
    // ОПРЕДЕЛЯЕМ МЕТОД КОТОРЫЙ СОЗДАЕТ НАМ ВЬЮ МОДЕЛЬ И МЫ ЕЕ ТЕПЕРЬ ПЕРЕОПРЕДЕЛЯЕМ
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
      //return super.create(modelClass) ПЕРЕПИСЫВАЕМ
        //ВОЗВРАЩАЕМ ВЬЮ МОДЕЛЬ ПЕРЕДАЕМ АПЛИКЕЙШЕН КОНТЕКСТ ДОБАВЛЯЕМ ЧТО ХОТИМ ПЕРЕДАТЬ
        // В НАШЕМ СЛУЧАЕ ТЕКСТ И КАСТИМ ВСЕ К T
        return MainViewModel(application,text) as T
    }
    //затем переходим туда где вью модель вызвали задаем параметры и передаем данные в нашем случае текст
}
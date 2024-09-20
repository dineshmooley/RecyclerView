package com.example.assignment7.firstScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FirstViewModel : ViewModel() {

    val colors = arrayOf("blue", "cyan", "green", "orange", "red", "white", "yellow")

    private var _navigateToSecond = MutableLiveData<Boolean>()
    val navigateToSecond : LiveData<Boolean>
        get() = _navigateToSecond

    fun onButtonClick() {
        _navigateToSecond.value = true
    }

    fun doneNavigatingToSecond()    {
        _navigateToSecond.value = false
    }
}
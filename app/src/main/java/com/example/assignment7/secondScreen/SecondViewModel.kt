package com.example.assignment7.secondScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondViewModel : ViewModel(){

    private val _navigateToFirst = MutableLiveData<Boolean>()
    val navigateToFirst : LiveData<Boolean>
        get() = _navigateToFirst

    fun onButtonClick() {
        _navigateToFirst.value = true
    }

    fun doneNavigating()    {
        _navigateToFirst.value = false
    }

}
package com.khanhth.welcome.view.authenticate

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthenticateViewModel @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : ViewModel() {
    init {
        sharedPreferences.edit().apply {
            putString("Pass", "Khanh")
            apply()
        }
    }

    val onSuccess: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    fun validatePass(rawPass: String) {
        val pass = sharedPreferences.getString("Pass", null)
        onSuccess.postValue(pass == rawPass)
    }
}
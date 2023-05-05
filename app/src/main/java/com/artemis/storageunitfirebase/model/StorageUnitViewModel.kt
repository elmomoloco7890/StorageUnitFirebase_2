package com.artemis.storageunitfirebase.model

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel

class StorageUnitViewModel: ViewModel() {
    fun getToasty(context: Context, message: String, toastType: Int){
        Toast.makeText(context, message, toastType).show()
    }
}
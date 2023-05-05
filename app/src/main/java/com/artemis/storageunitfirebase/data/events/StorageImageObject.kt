package com.artemis.storageunitfirebase.data.events

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object StorageImageObject {
    @JvmStatic @BindingAdapter("unitImage")
    fun loadImage(view: ImageView?, unitImage: String){
        Glide.with(view!!).load(unitImage).into(view)
    }
}
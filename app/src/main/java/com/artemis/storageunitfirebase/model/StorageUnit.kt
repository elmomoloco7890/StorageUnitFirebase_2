package com.artemis.storageunitfirebase.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StorageUnit(
    val unit_des: String? = null,
    val unit_file_type: String? = null,
    val unit_image: String? = null,
    val unit_name: String? = null
): Parcelable
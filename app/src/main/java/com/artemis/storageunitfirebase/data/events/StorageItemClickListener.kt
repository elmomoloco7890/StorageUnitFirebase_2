package com.artemis.storageunitfirebase.data.events

import com.artemis.storageunitfirebase.model.StorageUnit

interface StorageItemClickListener {
    fun onItemClicked(storageUnit: StorageUnit)
}
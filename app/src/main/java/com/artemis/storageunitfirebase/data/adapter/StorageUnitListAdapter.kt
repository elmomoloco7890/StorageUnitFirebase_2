package com.artemis.storageunitfirebase.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.artemis.storageunitfirebase.data.events.StorageItemClickListener
import com.artemis.storageunitfirebase.databinding.StorageUnitItemBinding
import com.artemis.storageunitfirebase.model.StorageUnit
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions

class StorageUnitListAdapter(
    options: FirebaseRecyclerOptions<StorageUnit>,
    private val clickListener: StorageItemClickListener
): FirebaseRecyclerAdapter<StorageUnit, StorageUnitListAdapter.UnitViewHolder?>(options) {

    private lateinit var binding: StorageUnitItemBinding

    class UnitViewHolder(var storageItems: StorageUnitItemBinding):RecyclerView.ViewHolder(storageItems.root){
        fun bind(curItem: StorageUnit, listener: StorageItemClickListener){
            storageItems.storageUnit = curItem
            storageItems.storageClicked = listener
            storageItems.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UnitViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val storageItemBinding = StorageUnitItemBinding.inflate(inflater, parent, false)
        binding = storageItemBinding
        return UnitViewHolder(storageItemBinding)
    }

    override fun onBindViewHolder(holder: UnitViewHolder, position: Int, model: StorageUnit) =
        holder.bind(model, clickListener)

}
package com.artemis.storageunitfirebase.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.artemis.storageunitfirebase.data.adapter.StorageUnitListAdapter
import com.artemis.storageunitfirebase.data.events.StorageItemClickListener
import com.artemis.storageunitfirebase.databinding.FragmentMainUnitBinding
import com.artemis.storageunitfirebase.model.StorageUnit
import com.artemis.storageunitfirebase.model.StorageUnitViewModel
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class MainUnitFragment : Fragment(), StorageItemClickListener {

    private var binding: FragmentMainUnitBinding?= null

    private lateinit var adapter: StorageUnitListAdapter

    private var storageUnitDB: DatabaseReference ?= null

    private val sharedViewModel: StorageUnitViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val mainUnitBinding = FragmentMainUnitBinding.inflate(inflater, container, false)
        binding = mainUnitBinding
        return mainUnitBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        storageUnitDB = FirebaseDatabase.getInstance().getReference("storage_unit")

        val options: FirebaseRecyclerOptions<StorageUnit> =
            FirebaseRecyclerOptions.Builder<StorageUnit>()
                .setQuery(storageUnitDB!!, StorageUnit::class.java).build()

        adapter = StorageUnitListAdapter(options, this)

        binding?.apply {
            mainUnitFragment = this@MainUnitFragment
            storageUnitAdapter = adapter
        }
    }

    override fun onItemClicked(storageUnit: StorageUnit) {
        for (units in 1..20){
            if (units == 1){
                sharedViewModel.getToasty(requireActivity(), "It goes to the nacho", Toast.LENGTH_SHORT)
                val action = MainUnitFragmentDirections.actionMainUnitFragmentToDetailUnitFragment(storageUnit)
                findNavController().navigate(action)
                break
            }
        }
    }

    override fun onStart() {
        super.onStart()
        adapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        adapter.stopListening()
    }


}
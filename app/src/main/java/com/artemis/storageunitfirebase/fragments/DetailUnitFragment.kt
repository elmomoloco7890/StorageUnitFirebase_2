package com.artemis.storageunitfirebase.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.artemis.storageunitfirebase.R
import com.artemis.storageunitfirebase.databinding.FragmentDetailUnitBinding
import com.artemis.storageunitfirebase.model.StorageUnitViewModel


class DetailUnitFragment : Fragment() {

    private var binding: FragmentDetailUnitBinding ?= null

    //private val sharedViewModel: StorageUnitViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val detailUnitBinding = FragmentDetailUnitBinding.inflate(inflater, container, false)
        binding = detailUnitBinding
        return detailUnitBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments

        if (bundle == null){
            Log.d("Confirmation", "Detail fragment didn't receive info")
            return
        }

        val detailArgs = bundle.let {
            DetailUnitFragmentArgs.fromBundle(it)
        }

        binding?.apply {
            detailUnitFragment = this@DetailUnitFragment
            storageUnitStuff = detailArgs.storageArgs
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    fun backHome(){
        findNavController().navigate(R.id.action_detailUnitFragment_to_homeUnitFragment)
    }


}
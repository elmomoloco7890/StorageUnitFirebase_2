package com.artemis.storageunitfirebase.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.artemis.storageunitfirebase.R
import com.artemis.storageunitfirebase.databinding.FragmentHomeUnitBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeUnitFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeUnitFragment : Fragment() {

    private var binding: FragmentHomeUnitBinding ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val homeUnitBinding = FragmentHomeUnitBinding.inflate(inflater, container, false)
        binding = homeUnitBinding
        return homeUnitBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            homeUnitFragment = this@HomeUnitFragment
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    fun launchToMain(){
        findNavController().navigate(R.id.action_homeUnitFragment_to_mainUnitFragment)
    }

}
package com.example.nippon.view.home.branch

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.nippon.R
import com.example.nippon.databinding.BranchFragmentBinding
import com.example.nippon.databinding.HomeFragmentBinding
import com.example.nippon.view.home.HomeDirections
import com.google.android.material.tabs.TabLayout

class BranchFragment : Fragment() {

    private lateinit var branchFragmentbinding: BranchFragmentBinding
    private lateinit var viewModel: BranchViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        branchFragmentbinding = BranchFragmentBinding.inflate(inflater)

//        branchFragmentbinding.btn1.setOnClickListener {
//            val action = BranchFragmentDirections.actionBranchFragmentToFltFragment()
//            Navigation.findNavController(branchFragmentbinding.btn1).navigate(action)
//        }
//        branchFragmentbinding.btn2.setOnClickListener {
//            Toast.makeText(activity, "Feature under development", Toast.LENGTH_SHORT).show()
//        }
//        branchFragmentbinding.btn3.setOnClickListener {
//            Toast.makeText(activity, "Feature under development", Toast.LENGTH_SHORT).show()
//        }

        branchFragmentbinding.branchFragmentTabLayout.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                val action = BranchFragmentDirections.actionBranchFragmentToFltFragment()
                Navigation.findNavController(branchFragmentbinding.branchFrameLayout).navigate(action)
                // Handle tab select
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Handle tab reselect
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // Handle tab unselect
            }
        })
        return branchFragmentbinding.root
    }


}
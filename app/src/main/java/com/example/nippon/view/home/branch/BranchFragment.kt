package com.example.nippon.view.home.branch

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.navigation.Navigation
import com.example.nippon.R
import com.example.nippon.databinding.BranchFragmentBinding
import com.example.nippon.databinding.HomeFragmentBinding
import com.example.nippon.view.home.HomeDirections
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class BranchFragment : Fragment() {

    private lateinit var branchFragmentbinding: BranchFragmentBinding
    private lateinit var viewModel: BranchViewModel

    val animalsArray = arrayOf(
        "FLT",
        "LIT",
        "RT"
    )
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

        val adapter = BranchViewPagerAdapter(childFragmentManager, lifecycle)
        branchFragmentbinding.viewPagerBranch.adapter = adapter



        TabLayoutMediator(branchFragmentbinding.branchFragmentTabLayout,branchFragmentbinding.viewPagerBranch){ tab,position ->
            tab.text = animalsArray[position]

        }.attach()

        return branchFragmentbinding.root
    }



}
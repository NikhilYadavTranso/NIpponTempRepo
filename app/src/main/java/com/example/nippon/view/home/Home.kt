package com.example.nippon.view.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import com.example.nippon.R
import com.example.nippon.base.BaseFragment
import com.example.nippon.databinding.HomeFragmentBinding
import com.example.nippon.databinding.LoginFragmentBinding
import com.example.nippon.databinding.SignUpFragmentBinding
import com.example.nippon.view.signUp.SignUpFragmentDirections

class Home : BaseFragment() {
    private lateinit var viewModel: HomeViewModel
    val isTempScreenVisible = false
    private lateinit var homeFragmentbinding: HomeFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeFragmentbinding = HomeFragmentBinding.inflate(inflater)

        homeFragmentbinding.demoHOME.isVisible = isTempScreenVisible
        demoUserOnClicks()
        branchUserOnClicks()

        return homeFragmentbinding.root
    }

    private fun branchUserOnClicks() {
        homeFragmentbinding.homeBtn1.setOnClickListener {
            val action = HomeDirections.actionHomeToBranchFragment()
            Navigation.findNavController(homeFragmentbinding.homeBtn1).navigate(action)
        }
    }

    private fun demoUserOnClicks() {
        homeFragmentbinding.btn1.setOnClickListener {
            val action = HomeDirections.actionHomeToBranchFragment()
            Navigation.findNavController(homeFragmentbinding.btn1).navigate(action)
        }
        homeFragmentbinding.btn2.setOnClickListener {
            val action = HomeDirections.actionHomeToRouteControllerFragment("RC")
            Navigation.findNavController(homeFragmentbinding.btn2).navigate(action)
        }
        homeFragmentbinding.btn3.setOnClickListener {
            val action = HomeDirections.actionHomeToRouteControllerFragment("V")
            Navigation.findNavController(homeFragmentbinding.btn3).navigate(action)
        }
    }


}
package com.example.nippon.view.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.nippon.R
import com.example.nippon.base.BaseFragment
import com.example.nippon.databinding.HomeFragmentBinding
import com.example.nippon.databinding.LoginFragmentBinding
import com.example.nippon.databinding.SignUpFragmentBinding
import com.example.nippon.view.signUp.SignUpFragmentDirections

class Home : BaseFragment() {
    private lateinit var viewModel: HomeViewModel
    private lateinit var homeFragmentbinding: HomeFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeFragmentbinding = HomeFragmentBinding.inflate(inflater)

        homeFragmentbinding.btn1.setOnClickListener {
            val action = HomeDirections.actionHomeToBranchFragment()
            Navigation.findNavController(homeFragmentbinding.btn1).navigate(action)
        }
        homeFragmentbinding.btn2.setOnClickListener {
            val action = HomeDirections.actionHomeToRouteControllerFragment()
            Navigation.findNavController(homeFragmentbinding.btn2).navigate(action)
        }
        homeFragmentbinding.btn3.setOnClickListener {
            val action = HomeDirections.actionHomeToRouteControllerFragment()
            Navigation.findNavController(homeFragmentbinding.btn3).navigate(action)
        }
        return homeFragmentbinding.root
    }



}
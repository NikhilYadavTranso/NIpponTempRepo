package com.example.nippon.view.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.nippon.R
import com.example.nippon.base.BaseFragment
import com.example.nippon.databinding.HomeFragmentBinding
import com.example.nippon.databinding.LoginFragmentBinding
import com.example.nippon.databinding.SignUpFragmentBinding
import com.example.nippon.view.home.adapter.HomeGridAdapter
import com.example.nippon.view.signUp.SignUpFragmentDirections

class Home : BaseFragment() {
    private lateinit var viewModel: HomeViewModel
    val isTempScreenVisible = false

    private var gridImageList = mutableListOf<Int>()
    private var gridTextList = mutableListOf<String>()

    private lateinit var homeFragmentbinding: HomeFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeFragmentbinding = HomeFragmentBinding.inflate(inflater)

        addToList()

        homeFragmentbinding.homeGridLayout.layoutManager = GridLayoutManager(homeFragmentbinding.root.context,2)
        homeFragmentbinding.homeGridLayout.adapter = HomeGridAdapter(gridTextList,gridImageList)


        homeFragmentbinding.homeGridLayout.setOnClickListener(){

            Toast.makeText(homeFragmentbinding.root.context, "clicked", Toast.LENGTH_SHORT).show()
        }
        //Commenting below
//        homeFragmentbinding.demoHOME.isVisible = isTempScreenVisible
//        demoUserOnClicks()
//        branchUserOnClicks()

        return homeFragmentbinding.root
    }
    private fun addToList(){
        gridTextList.add("Pending Vehicle")
        gridTextList.add("Pending Consignment")
        gridTextList.add("Pending EWay Bill")
        gridTextList.add("Pending Revenue")
        gridTextList.add("THC Closing")
        gridTextList.add("THC Payment Update")
        gridTextList.add("LTL Closing")
        gridTextList.add("LTL Payment Update")

        gridImageList.add(R.drawable.peningvehicle)
        gridImageList.add(R.drawable.pendingconsignments)
        gridImageList.add(R.drawable.pendingebill)
        gridImageList.add(R.drawable.pendingebill)
        gridImageList.add(R.drawable.thcclosing)
        gridImageList.add(R.drawable.thcpaymentupdate)
        gridImageList.add(R.drawable.ltlclosing)
        gridImageList.add(R.drawable.ltlpayment)
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
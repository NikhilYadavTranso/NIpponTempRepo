package com.example.nippon.view.home.routecountroler

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nippon.R
import com.example.nippon.databinding.AssignVehicleFragmentBinding
import com.example.nippon.databinding.RouteControllerFragmentBinding

class AssignVehicleFragment : Fragment() {
    private lateinit var assignVehicleFragmentBinding: AssignVehicleFragmentBinding


    private lateinit var viewModel: AssignVehicleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        assignVehicleFragmentBinding = AssignVehicleFragmentBinding.inflate(inflater)


        return assignVehicleFragmentBinding.root
    }


}
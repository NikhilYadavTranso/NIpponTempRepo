package com.example.nippon.view.home.routecountroler

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.nippon.R
import com.example.nippon.databinding.AssignVehicleFragmentBinding
import com.example.nippon.databinding.RouteControllerFragmentBinding
import com.example.nippon.model.SerialData
import com.example.nippon.model.request.Requests
import com.example.nippon.view.login.LoginFragmentDirections

class AssignVehicleFragment : Fragment() {
    private lateinit var assignVehicleFragmentBinding: AssignVehicleFragmentBinding
    private lateinit var requests: Requests

    private lateinit var viewModel: AssignVehicleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        assignVehicleFragmentBinding = AssignVehicleFragmentBinding.inflate(inflater)

        requests = arguments?.getSerializable("myArg") as Requests
        val userType = arguments?.get("userType").toString()
        assignVehicleFragmentBinding.assignVehicleRequestId.setText(requests.Requestid)
        if(userType == "V"){
            assignVehicleFragmentBinding.submitAssignVehicleToVender.isVisible = false
            assignVehicleFragmentBinding.orAssignVehicle.isVisible = false
        }
        assignVehicleFragmentBinding.submitAssignVehicle.setOnClickListener {

            val action = AssignVehicleFragmentDirections.actionAssignVehicleFragmentToLrGenerationFragment()
            Navigation.findNavController(assignVehicleFragmentBinding.submitAssignVehicle).navigate(action)

        }
        assignVehicleFragmentBinding.submitAssignVehicleToVender.setOnClickListener {
            Toast.makeText(assignVehicleFragmentBinding.root.context, "Request sent to Vender", Toast.LENGTH_SHORT).show()
        }
        return assignVehicleFragmentBinding.root
    }


}
package com.example.nippon.view.home.routecountroler

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.nippon.R
import com.example.nippon.databinding.AssignVehicleFragmentBinding
import com.example.nippon.databinding.RouteControllerFragmentBinding
import com.example.nippon.model.SerialData

class AssignVehicleFragment : Fragment() {
    private lateinit var assignVehicleFragmentBinding: AssignVehicleFragmentBinding
    private lateinit var serialData: SerialData

    private lateinit var viewModel: AssignVehicleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        assignVehicleFragmentBinding = AssignVehicleFragmentBinding.inflate(inflater)

        serialData = arguments?.getSerializable("myArg") as SerialData
        assignVehicleFragmentBinding.assignVehicleRequestId.setText(serialData.request.Requestid)

        assignVehicleFragmentBinding.submitAssignVehicle.setOnClickListener {
            Toast.makeText(assignVehicleFragmentBinding.root.context, "Vehicle Assigned", Toast.LENGTH_SHORT).show()
        }
        return assignVehicleFragmentBinding.root
    }


}
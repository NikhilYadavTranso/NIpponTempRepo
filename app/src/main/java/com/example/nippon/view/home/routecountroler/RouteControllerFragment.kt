package com.example.nippon.view.home.routecountroler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nippon.databinding.RouteControllerFragmentBinding
import com.example.nippon.model.SerialData
import com.example.nippon.model.request.Requests

class RouteControllerFragment : Fragment() {

    private lateinit var routeControllerFragmentbinding: RouteControllerFragmentBinding
    lateinit var request :Requests
    private lateinit var requestAdapter :RequestListAdapter
    private  val viewModel: RouteControllerViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val userType = arguments?.get("userType").toString()
        val listener = object: RequestListAdapter.CustomViewHolderListener {
            override fun onCustomItemClicked(request: Requests) {

                val passingRequests = SerialData(request)
                val action = RouteControllerFragmentDirections.actionRouteControllerFragmentToAssignVehicleFragment(request,
                    userType
                )
                Navigation.findNavController(routeControllerFragmentbinding.routeRecycler).navigate(action)

            }

        }
        requestAdapter = RequestListAdapter(arrayListOf(),listener)
        routeControllerFragmentbinding = RouteControllerFragmentBinding.inflate(inflater)
        routeControllerFragmentbinding.routeRecycler.layoutManager = LinearLayoutManager(routeControllerFragmentbinding.root.context)
        routeControllerFragmentbinding.routeRecycler.adapter = requestAdapter
        viewModel.fetchRequests()

        viewModel.requests.observe(viewLifecycleOwner) { requests ->
            requests?.let {
                requestAdapter.updateRequests(it)
            }
        }
        return routeControllerFragmentbinding.root
    }


}
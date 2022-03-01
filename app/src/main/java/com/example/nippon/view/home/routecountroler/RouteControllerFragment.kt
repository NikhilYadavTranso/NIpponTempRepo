package com.example.nippon.view.home.routecountroler

import android.app.DownloadManager
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nippon.R
import com.example.nippon.databinding.HomeFragmentBinding
import com.example.nippon.databinding.RouteControllerFragmentBinding
import com.example.nippon.model.SerialData
import com.example.nippon.model.request.Requests
import com.example.nippon.view.home.HomeDirections
import com.example.nippon.view.login.LoginFragmentDirections

class RouteControllerFragment : Fragment() {

    private lateinit var routeControllerFragmentbinding: RouteControllerFragmentBinding
    lateinit var request :Requests
    private lateinit var requestAdapter :RequestListAdapter
    private  val viewModel: RouteControllerViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val listener = object: RequestListAdapter.CustomViewHolderListener {
            override fun onCustomItemClicked(request: Requests) {

                val passingRequests = SerialData(request)
                Toast.makeText(activity, "Feature under development", Toast.LENGTH_SHORT).show()
                val action = RouteControllerFragmentDirections.actionRouteControllerFragmentToAssignVehicleFragment()
                val bundle = bundleOf("passingRequests" to passingRequests)

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
package com.example.nippon.view.home.routecountroler

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nippon.R
import com.example.nippon.databinding.HomeFragmentBinding
import com.example.nippon.databinding.RouteControllerFragmentBinding
import com.example.nippon.view.home.HomeDirections

class RouteControllerFragment : Fragment() {
    private val requestAdapter = requestListAdapter(arrayListOf())
    private lateinit var routeControllerFragmentbinding: RouteControllerFragmentBinding

    private  val viewModel: RouteControllerViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        routeControllerFragmentbinding = RouteControllerFragmentBinding.inflate(inflater)
        routeControllerFragmentbinding.routeRecycler.layoutManager = LinearLayoutManager(routeControllerFragmentbinding.root.context)
        routeControllerFragmentbinding.routeRecycler.adapter = requestAdapter
        viewModel.fetchRequests()

        viewModel.requests.observe(viewLifecycleOwner) { requests ->
            requests?.let { requestAdapter.updateRequests(it) }
        }
        return routeControllerFragmentbinding.root
    }


}
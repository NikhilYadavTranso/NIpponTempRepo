package com.example.nippon.view.home.branch.flt

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.nippon.R
import com.example.nippon.databinding.BranchFragmentBinding
import com.example.nippon.databinding.FltFragmentBinding
import com.example.nippon.view.home.HomeDirections

class FltFragment : Fragment() {

    private lateinit var fltFragmentbinding: FltFragmentBinding
    private lateinit var viewModel: FltViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fltFragmentbinding = FltFragmentBinding.inflate(inflater)

        fltFragmentbinding.btn1.setOnClickListener {
            Toast.makeText(activity, "Request Generated", Toast.LENGTH_SHORT).show()
        }
        return fltFragmentbinding.root
    }



}
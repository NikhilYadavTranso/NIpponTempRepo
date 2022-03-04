package com.example.nippon.view.home.routecountroler

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.nippon.R
import com.example.nippon.databinding.AssignVehicleFragmentBinding
import com.example.nippon.databinding.LrGenerationFragmentBinding

class LrGenerationFragment : Fragment() {
    private lateinit var lrGenerationFragmentBinding: LrGenerationFragmentBinding

    private lateinit var viewModel: LrGenerationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        lrGenerationFragmentBinding = LrGenerationFragmentBinding.inflate(inflater)
        lrGenerationFragmentBinding.confirmLrGeneration.setOnClickListener {
            Toast.makeText(lrGenerationFragmentBinding.root.context, "Vehicle Booking Confirmed", Toast.LENGTH_SHORT).show()
        }
        return lrGenerationFragmentBinding.root
    }



}
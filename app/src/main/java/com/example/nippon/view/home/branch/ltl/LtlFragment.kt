package com.example.nippon.view.home.branch.ltl

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nippon.R
import com.example.nippon.base.BaseFragment

class LtlFragment : BaseFragment() {


    private lateinit var viewModel: LtlViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.ltl_fragment, container, false)
    }



}
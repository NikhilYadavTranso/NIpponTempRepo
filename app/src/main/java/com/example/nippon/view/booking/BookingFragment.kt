package com.example.nippon.view.booking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.nippon.R
import com.example.nippon.base.BaseFragment
import com.example.nippon.databinding.FragmentBookingBinding
import com.example.nippon.databinding.HomeFragmentBinding
import com.example.nippon.databinding.LoginFragmentBinding

class BookingFragment : BaseFragment() {

    private lateinit var bookingFragmentbinding: FragmentBookingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bookingFragmentbinding = FragmentBookingBinding.inflate(inflater)

        bookingFragmentbinding.bookingFLT.setOnClickListener{
            val action = BookingFragmentDirections.actionBookingFragmentToFltFragment2()
            Navigation.findNavController(bookingFragmentbinding.bookingFLT).navigate(action)
        }
        return bookingFragmentbinding.root
        //return inflater.inflate(R.layout.fragment_booking, container, false)
    }


}
package com.example.nippon.view.home.routecountroler

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nippon.model.Requests

class RouteControllerViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    val requests = MutableLiveData<List<Requests>>()

     fun fetchRequests() {




        val mockData: List<Requests> = listOf(
            Requests("Request 1"),
            Requests("Request 2"),
            Requests("Request 3"),
            Requests("Request 4"),
            Requests("Request 5"),
            Requests("Request 6"),
            Requests("Request 7"),
            Requests("Request 8"),

        )
        requests.value = mockData
//        internshipLoadError.value = false
//        loading.value = false


    }
}
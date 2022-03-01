package com.example.nippon.view.home.routecountroler

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nippon.model.request.Requests

class RouteControllerViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    val requests = MutableLiveData<List<Requests>>()

     fun fetchRequests() {




        val mockData: List<Requests> = listOf(
            Requests("Request 1", ""),
            Requests("Request 2", ""),
            Requests("Request 3", ""),
            Requests("Request 4", ""),
            Requests("Request 5", ""),
            Requests("Request 6", ""),
            Requests("Request 7", ""),
            Requests("Request 8", ""),
            Requests("Request 9", ""),
            Requests("Request 10", ""),
            Requests("Request 11", ""),
            Requests("Request 12", ""),
            Requests("Request 13", ""),
            Requests("Request 14", ""),
            Requests("Request 15", ""),
            Requests("Request 16", ""),
            Requests("Request 17", ""),

        )
        requests.value = mockData
//        internshipLoadError.value = false
//        loading.value = false


    }
}
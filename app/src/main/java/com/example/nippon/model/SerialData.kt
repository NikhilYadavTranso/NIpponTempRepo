package com.example.nippon.model

import com.example.nippon.model.request.Requests
import java.io.Serializable

class SerialData(mRequest: Requests) :Serializable {
    var request:Requests = mRequest

}
package com.example.nippon.view.home.routecountroler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nippon.R
import com.example.nippon.model.Requests

class requestListAdapter(var requests: ArrayList<Requests>): RecyclerView.Adapter<requestListAdapter.RequestsViewHolder>() {
    class RequestsViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val requestName = view.findViewById<TextView>(R.id.requestName)
        fun bind(request: Requests) {
            requestName.text = request.RequestName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
            RequestsViewHolder (
    LayoutInflater.from(parent.context).inflate(
        R.layout.item_request, parent, false)
    )

    override fun onBindViewHolder(holder: RequestsViewHolder, position: Int) {
        holder.bind(requests[position])
    }

    override fun getItemCount(): Int {
        return requests.size
    }

    fun updateRequests(it: List<Requests>) {
        requests.clear()
        requests.addAll(it)
        notifyDataSetChanged()

    }
}
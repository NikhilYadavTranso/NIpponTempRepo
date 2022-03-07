package com.example.nippon.view.home.branch

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.nippon.view.home.branch.flt.FltFragment
import com.example.nippon.view.home.branch.ltl.LtlFragment

private const val NUM_TABS = 3

public class BranchViewPagerAdapter (fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return FltFragment()
            1 -> return LtlFragment()
        }
        return FltFragment()
    }
}
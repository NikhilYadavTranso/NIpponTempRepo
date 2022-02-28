package com.example.nippon.view

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.nippon.R
import com.example.nippon.base.BaseActivity
import com.example.nippon.databinding.ActivityLoginBinding

class ParentActivity : BaseActivity() {
    private lateinit var _binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = DataBindingUtil.setContentView(this,R.layout.activity_login)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.login_nav_host) as NavHostFragment
        val navController = navHostFragment.navController


    }

    companion object {
        private const val TAG = "ParentActivity"
    }
}
package com.example.nippon.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.nippon.R
import com.example.nippon.base.BaseActivity
import com.example.nippon.databinding.ActivityLoginBinding
import com.example.nippon.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private lateinit var _binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        _binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_nav_host) as NavHostFragment
        val navController = navHostFragment.navController

        setupWithNavController(_binding.mainActivityBottomNav, navController)

    }
}
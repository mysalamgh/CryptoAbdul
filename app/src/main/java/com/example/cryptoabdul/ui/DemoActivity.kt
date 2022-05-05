package com.example.cryptoabdul.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.cryptoabdul.MyApplication
import com.example.cryptoabdul.R
import com.example.cryptoabdul.dao.CurrencyInfoDao
import com.example.cryptoabdul.databinding.ActivityDemoBinding
import com.example.cryptoabdul.viewmodel.CurrencyInfoViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DemoActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityDemoBinding
    private lateinit var currencyInfoDao: CurrencyInfoDao
    private val currencyInfoViewModel: CurrencyInfoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        currencyInfoDao = (application as MyApplication).database.currencyInfoDao()

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        currencyInfoViewModel.getSelectedCurrencyInfo().observe(this) { currency ->
            Snackbar.make(binding.root, "${currency.name} is clicked!", Snackbar.LENGTH_LONG).show()
        }

        binding.loadButton.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                val list = currencyInfoDao.getAll()
                withContext(Dispatchers.Main) {
                    currencyInfoViewModel.setCurrencyInfoList(list)
                }
            }
        }

        binding.sortButton.setOnClickListener {
            currencyInfoViewModel.getCurrencyInfoList().value?.let { mList ->
                lifecycleScope.launch(Dispatchers.IO) {
                    withContext(Dispatchers.Main) {
                        currencyInfoViewModel.setCurrencyInfoList(mList.sortedBy { it.name })
                    }
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}
package com.example.cryptoabdul.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.cryptoabdul.adapter.CurrencyInfoItemAdapter
import com.example.cryptoabdul.databinding.FragmentCurrencyListBinding
import com.example.cryptoabdul.viewmodel.CurrencyInfoViewModel

class CurrencyListFragment : Fragment() {

    private lateinit var binding: FragmentCurrencyListBinding
    private val currencyInfoViewModel: CurrencyInfoViewModel by activityViewModels()
    private lateinit var currencyInfoItemAdapter: CurrencyInfoItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCurrencyListBinding.inflate(inflater, container, false)
        currencyInfoItemAdapter = CurrencyInfoItemAdapter(currencyInfoViewModel)
        binding.currencyListRecyclerView.adapter = currencyInfoItemAdapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currencyInfoViewModel.getCurrencyInfoList().observe(viewLifecycleOwner) { list ->
            currencyInfoItemAdapter.updateList(list)
        }
    }
}
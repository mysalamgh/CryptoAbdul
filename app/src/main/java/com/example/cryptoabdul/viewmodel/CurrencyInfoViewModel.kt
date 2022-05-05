package com.example.cryptoabdul.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cryptoabdul.model.CurrencyInfo

class CurrencyInfoViewModel : ViewModel() {

    private val currencyInfoList = MutableLiveData<List<CurrencyInfo>>(listOf())
    private val selectedCurrencyInfo = MutableLiveData<CurrencyInfo>()

    fun getCurrencyInfoList(): LiveData<List<CurrencyInfo>> {
        return currencyInfoList
    }

    fun setCurrencyInfoList(list: List<CurrencyInfo>) {
        this.currencyInfoList.value = list
    }

    fun getSelectedCurrencyInfo(): LiveData<CurrencyInfo> {
        return selectedCurrencyInfo
    }

    fun setSelectedCurrencyInfo(currencyInfo: CurrencyInfo) {
        this.selectedCurrencyInfo.value = currencyInfo
    }

}
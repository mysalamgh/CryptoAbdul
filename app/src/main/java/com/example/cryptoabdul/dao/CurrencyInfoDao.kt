package com.example.cryptoabdul.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cryptoabdul.model.CurrencyInfo

@Dao
interface CurrencyInfoDao {
    @Query("SELECT * FROM currency_info")
    suspend fun getAll(): List<CurrencyInfo>

    @Insert
    suspend fun insertAll(currencyInfoList: List<CurrencyInfo>)
}
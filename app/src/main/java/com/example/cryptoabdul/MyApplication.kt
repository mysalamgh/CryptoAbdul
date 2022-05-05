package com.example.cryptoabdul

import android.app.Application
import com.example.cryptoabdul.db.AppDatabase

class MyApplication : Application() {

    val database by lazy { AppDatabase.getDatabase(this) }

}

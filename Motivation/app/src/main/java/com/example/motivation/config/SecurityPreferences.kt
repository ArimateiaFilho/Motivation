package com.example.motivation.config

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences(context: Context) {

    private val security: SharedPreferences =
        context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)

    fun save(key: String, name: String){
        security.edit().putString(key, name).apply()
    }

    fun getName(key: String): String {
        return security.getString(key, "") ?: ""
    }

}
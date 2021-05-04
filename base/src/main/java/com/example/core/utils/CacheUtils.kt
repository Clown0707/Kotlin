package com.example.core.utils

import android.annotation.SuppressLint
import android.content.Context
import com.example.core.BaseApplication
import com.example.core.R

object CacheUtils {
    @SuppressLint("StaticFieldLeak")
    private val context: Context = BaseApplication.currentApplication
    private val SP = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    @JvmStatic
    fun save(key: String?, value: String?) = SP.edit().putString(key, value).apply()

    @JvmStatic
    operator fun get(key: String?) = SP.getString(key, null)
}
package com.example.core.utils

import android.content.res.Resources
import android.util.TypedValue
import android.widget.Toast
import com.example.core.BaseApplication

object Utils {
    private val displayMetrics = Resources.getSystem().displayMetrics

    @JvmStatic
    fun Float.dp2px(): Float = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, displayMetrics)


    @JvmOverloads
    @JvmStatic
    fun toast(string: String?, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(BaseApplication.currentApplication, string, duration).show()
    }
}
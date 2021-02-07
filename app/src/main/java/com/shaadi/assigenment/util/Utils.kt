package com.shaadi.assigenment.util

import android.content.Context
import android.content.res.Resources
import android.widget.Toast


class Utils {
    companion object {

        fun showToast(msg:String, context: Context){
            Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()
        }

        fun getScreenWidth(): Int {
            return Resources.getSystem().displayMetrics.widthPixels
        }
    }
}
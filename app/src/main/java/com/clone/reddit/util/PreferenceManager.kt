package com.clone.reddit.util

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class PreferenceManager() {

    lateinit var preferences: SharedPreferences

    companion object {
        fun getPreferences(activity: Activity): PreferenceManager{
            val preferenceManager = PreferenceManager()
            preferenceManager.preferences = activity.getPreferences(Context.MODE_PRIVATE)
            return preferenceManager;
        }
    }

    fun getStoredString(key:String): String{
        return preferences!!.getString(key,"")!!
    }


    suspend fun storeString(key:String, value: String){
        with(preferences.edit()){
            putString(key, value)
            apply();
        }
    }
}
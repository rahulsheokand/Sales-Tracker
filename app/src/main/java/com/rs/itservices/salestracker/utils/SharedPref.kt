package co.e.io.sales.tracker.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

/**
 * Created by ***lovepreetkaur240@gmail.com*** 25june,2021
 */
object SharedPref {
    const val PREF_NAME = "your preferences name"
    @SuppressLint("WorldWriteableFiles")
    val MODE: Int = Context.MODE_PRIVATE
    const val USER_DATA = "USER_DATA"
    const val TOKEN = "TOKEN"
    const val USER_ID = "USER_ID_NEW"
    const val USER_NAME = "USER_NAME"
    const val NAME = "NAME"
    const val EMAIL = "EMAIL"
    const val PHONE = "PHONE"
    const val address = "address"
    const val PHOTO_URL = "PHOTO_URL"
    const val IsLogin = "IsLogin"
    const val ALIGNMENT_PREF = "AlignmentPref"
    const val isAuthenticate = "isAuthenticate"

    fun writeBoolean(context: Context, key: String?, value: Boolean) {
        getEditor(context).putBoolean(key, value).commit()
    }

    fun readBoolean(
        context: Context, key: String?,
    ): Boolean {
        return getPreferences(context).getBoolean(key, false)
    }

    fun writeInteger(context: Context, key: String?, value: Int) {
        getEditor(context).putInt(key, value).commit()
    }

    fun readInteger(context: Context, key: String?, defValue: Int): Int {
        return getPreferences(context).getInt(key, defValue)
    }

    fun writeString(context: Context, key: String?, value: String?) {
        getEditor(context).putString(key, value).commit()
    }

    fun readString(context: Context, key: String?): String? {
        return getPreferences(context).getString(key, "defValue")
    }

    fun writeFloat(context: Context, key: String?, value: Float) {
        getEditor(context).putFloat(key, value).commit()
    }

    fun readFloat(context: Context, key: String?, defValue: Float): Float {
        return getPreferences(context).getFloat(key, defValue)
    }

    fun writeLong(context: Context, key: String?, value: Long) {
        getEditor(context).putLong(key, value).commit()
    }

    fun readLong(context: Context, key: String?, defValue: Long): Long {
        return getPreferences(context).getLong(key, defValue)
    }

    fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF_NAME, MODE)
    }

    fun getEditor(context: Context): SharedPreferences.Editor {
        return getPreferences(context).edit()
    }
}
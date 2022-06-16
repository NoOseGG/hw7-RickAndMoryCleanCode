package com.example.rickandmortycleancode.manager

import android.content.Context

class SharedPrefsManager(context: Context) {

    val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    var nightMode: NightMode by enumPref(KEY_NIGHT_MODE, NightMode.SYSTEM)

    private inline fun <reified E : Enum<E>> enumPref(key: String, defaultValue: E) =
        PrefsDelegate(
            sharedPreferences,
            getValue = { getString(key, null)?.let(::enumValueOf) ?: defaultValue },
            setValue = { putString(key, it.name) }
        )

    companion object {
        private const val PREFS_NAME = "prefs"
        private const val KEY_NIGHT_MODE = "night_mode"
    }
}
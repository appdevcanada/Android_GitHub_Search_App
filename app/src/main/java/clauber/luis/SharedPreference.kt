package clauber.luis

/*
* Created by Luis Souza on November 05, 2019
*/
import android.content.Context
import android.content.SharedPreferences
import clauber.luis.R

class SharedPreference(private val context: Context = TheApp.context) {

    // region Properties
    private val preferencesName = context.getString(R.string.app_name) // use the app name
    private val sharedPref: SharedPreferences = context.getSharedPreferences(
        preferencesName,
        Context.MODE_PRIVATE
    )
    // endregion

    // region Methods
    fun contains(KEY_NAME: String): Boolean {
        return sharedPref.contains(KEY_NAME)
    }

    fun removeValue(KEY_NAME: String) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.remove(KEY_NAME)
        editor.apply()
    }

    fun clearSharedPreference() {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.clear()
        editor.apply()
    }

    fun getAll(): Map<String, *> {
        return sharedPref.all
    }
    // endregion

    // region Set methods
    fun save(KEY_NAME: String, text: String) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putString(KEY_NAME, text)
        editor.apply()
    }

    fun save(KEY_NAME: String, number: Int) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putInt(KEY_NAME, number)
        editor.apply()
    }

    fun save(KEY_NAME: String, number: Long) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putLong(KEY_NAME, number)
        editor.apply()
    }

    fun save(KEY_NAME: String, number: Float) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putFloat(KEY_NAME, number)
        editor.apply()
    }

    fun save(KEY_NAME: String, value: Boolean) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putBoolean(KEY_NAME, value)
        editor.apply()
    }

    fun save(KEY_NAME: String, value: Set<String>) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putStringSet(KEY_NAME, value)
        editor.apply()
    }
    // endregion

    // region Get methods
    fun getValueString(KEY_NAME: String): String? {
        return sharedPref.getString(KEY_NAME, null)
    }

    fun getValueInt(KEY_NAME: String): Int? {
        return sharedPref.getInt(KEY_NAME, -1)
    }

    fun getValueLong(KEY_NAME: String): Long? {
        return sharedPref.getLong(KEY_NAME, -1)
    }

    fun getValueFloat(KEY_NAME: String): Float? {
        return sharedPref.getFloat(KEY_NAME, 0.0f)
    }

    fun getValueBoolean(KEY_NAME: String): Boolean? {
        return sharedPref.getBoolean(KEY_NAME, false)
    }

    fun getValueSet(KEY_NAME: String): Set<String>? {
        return sharedPref.getStringSet(KEY_NAME, null);
    }
    // endregion
}
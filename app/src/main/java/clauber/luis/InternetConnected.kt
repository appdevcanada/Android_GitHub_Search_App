package clauber.luis

/*
* Created by Luis Souza on October 28, 2019
*/

import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import kotlin.system.exitProcess

/*
 * requires these permissions:
 *     <uses-permission android:name="android.permission.INTERNET"/>
 *     <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
 *
 *  requires these string values in strings.xml
 *     <string name="message_title">Network Error</string>
 *     <string name="message_text">This App requires an internet connection</string>
 *
*/

class InternetConnected(private val context: Context) {

// region Methods
    fun checkNetworkConnectivity(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        return if (android.os.Build.VERSION.SDK_INT >=  android.os.Build.VERSION_CODES.M) {
            postMarshmallowInternetCheck(connectivityManager)
        } else {
            preMarshmallowInternetCheck(connectivityManager)
        }
    }

    // Before Marshmallow get from activeNetworkInfo in the connectivityManager
    private fun preMarshmallowInternetCheck(connectivityManager: ConnectivityManager): Boolean {
        val activeNetwork = connectivityManager.activeNetworkInfo
        if (activeNetwork != null) {
            return (activeNetwork.type == ConnectivityManager.TYPE_WIFI ||
                    activeNetwork.type == ConnectivityManager.TYPE_MOBILE)
        }
        return false
    }

    // Marshmallow and up get from activeNetwork of connectivityManager
    private fun postMarshmallowInternetCheck(connectivityManager: ConnectivityManager): Boolean {
        val network = connectivityManager.activeNetwork
        val connection = connectivityManager.getNetworkCapabilities(network)

        return connection != null && (connection.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                connection.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR))
    }

    fun outputErrorMessage(){
        AlertDialog.Builder(context)
            .setTitle(R.string.message_title)
            .setMessage(R.string.message_text)
            //.setPositiveButton(R.string.retry)  {_,_ -> }
            .setNegativeButton(R.string.quit) { _ , _ ->  exitProcess(-1) }
            .show()
    }
// endregion
}
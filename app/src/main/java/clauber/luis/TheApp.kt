package clauber.luis

/*
* Created by Clauber Ferreira on November 05, 2019
* Created by Luis Souza on November 05, 2019
*/

import android.app.Application
import android.content.Context

class TheApp : Application() {

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    companion object {
        lateinit var context: Context
            private set
    }
}
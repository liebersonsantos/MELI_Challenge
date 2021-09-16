package br.com.liebersonsantos.melichallenge

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * Created by lieberson on 9/13/21.
 * @author lieberson.xsantos@gmail.com
 */
@HiltAndroidApp
class CustomApp: Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
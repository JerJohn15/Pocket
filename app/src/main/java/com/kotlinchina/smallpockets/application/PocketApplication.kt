package com.kotlinchina.smallpockets.application

import android.app.Application
import com.evernote.client.android.EvernoteSession
import io.realm.Realm
import io.realm.RealmConfiguration

class PocketApplication : Application() {

    companion object {
        val CONSUMER_KEY = "xxxx";
        val CONSUMER_SECRET = "xxxx";
        val EVERNOTE_SERVICE = EvernoteSession.EvernoteService.SANDBOX;
    }
    var everNoteSession: EvernoteSession? = null

    override fun onCreate() {
        super.onCreate()
        setupRealm()
        setupEvernoteSession()
    }

    private fun setupRealm() {
        val realmConfiguration = RealmConfiguration.Builder(this).build()
        Realm.setDefaultConfiguration(realmConfiguration)
    }

    private fun setupEvernoteSession() {
        everNoteSession = EvernoteSession.Builder(this)
                .setEvernoteService(EVERNOTE_SERVICE)
                .setSupportAppLinkedNotebooks(false)
                .build(CONSUMER_KEY, CONSUMER_SECRET)
                .asSingleton()
    }
}
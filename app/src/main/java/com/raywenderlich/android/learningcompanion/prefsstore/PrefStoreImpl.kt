package com.raywenderlich.android.learningcompanion.prefsstore

import android.content.Context
import androidx.datastore.preferences.SharedPreferencesMigration
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import com.raywenderlich.android.learningcompanion.di.PREFS_NAME
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

private const val STORE_NAME = "learning_data_store"

class PrefStoreImpl @Inject constructor(@ApplicationContext context: Context): PrefsStore {

    //created Obj of Data store, migrated data from sharedPreferences to Data store.
    val dataStore = context.createDataStore(name = STORE_NAME, migrations = listOf(
        SharedPreferencesMigration(context = context, sharedPreferencesName = PREFS_NAME)))

    override fun isNightMode(): Flow<Boolean> {
        // dataStore.data throws an IOException if it can't read the data
//        return  dataStore.data.catch {
//
//        }
    }

    override suspend fun toggleNightMode() {

    }

    private object PreferenceKey {  //created a key for data store
        val NIGHT_MODE_KEY = preferencesKey<Boolean>("dark_theme_enabled")
    }
}
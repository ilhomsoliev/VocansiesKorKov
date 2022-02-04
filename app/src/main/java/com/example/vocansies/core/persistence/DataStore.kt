package com.example.vocansies.core.persistence

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import javax.inject.Inject
import android.widget.Toast
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore("settings")

class DataStore @Inject constructor(
   @ApplicationContext val context: Context
) {

    /*//Create the dataStore
    private val dataStore: DataStore<Preferences> = context.createDataStore(name = "user_prefs")
*/
    //Create some keys
    companion object {
        val USER_TOKEN_KEY = stringPreferencesKey("USER_TOKEN")
        val TYPE_MAP_SCREEN = stringPreferencesKey("TYPE_MAP_SCREEN")
    }

    //Store user data
    suspend fun storeUserToken(token: String) {
       context.dataStore.edit{
            it[USER_TOKEN_KEY] = token
        }
    }

    suspend fun storeTypeMapScreen(type: String) {
        context.dataStore.edit{
            it[TYPE_MAP_SCREEN] = type
        }
    }

    //Create an age flow
    val userTokenFlow: Flow<String> = context.dataStore.data.map {
        val token = it[USER_TOKEN_KEY] ?: ""
        token
    }

    val typeMapScreenFlow: Flow<String> = context.dataStore.data.map {
        val type = it[TYPE_MAP_SCREEN] ?: ""
        type
    }
}
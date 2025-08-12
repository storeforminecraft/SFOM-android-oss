package com.storeforminecraft.app.core.auth.datasource

import com.google.firebase.auth.FirebaseAuth
import com.storeforminecraft.app.core.data.datasource.RemoteAuthDataSource
import javax.inject.Inject

class FirestoreAuthDataSource @Inject constructor(val firebaseAuth: FirebaseAuth) :
    RemoteAuthDataSource {
    override fun getCurrentUserId(): String? {
        return firebaseAuth.currentUser?.uid
    }
}
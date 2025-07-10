package com.storeforminecraft.app.datasource

interface RemoteUserDataSource {
    suspend fun getCurrentUserUid(): String?
}
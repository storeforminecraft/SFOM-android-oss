package com.storeforminecraft.app.core.data.datasource

interface RemoteUserDataSource {
    suspend fun getCurrentUserUid(): String?
}
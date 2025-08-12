package com.storeforminecraft.app.core.data.datasource

interface RemoteAuthDataSource {
    fun getCurrentUserId(): String?
}
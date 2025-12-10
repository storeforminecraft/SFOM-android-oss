package com.storeforminecraft.app.core.ui.delegate

import androidx.lifecycle.SavedStateHandle
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class SavedStateDelegate<T>(
    private val savedStateHandle: SavedStateHandle,
    private val key: String,
    private val defaultValue: T
) : ReadWriteProperty<Any, T> {

    override fun getValue(thisRef: Any, property: KProperty<*>): T {
        return savedStateHandle.get<T>(key) ?: defaultValue
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
        savedStateHandle[key] = value
    }
}
package com.storeforminecraft.app.core.common.util

import java.time.LocalDateTime

fun LocalDateTime.format(type: DateFormatType): String {
    return this.format(type.formatter)
}
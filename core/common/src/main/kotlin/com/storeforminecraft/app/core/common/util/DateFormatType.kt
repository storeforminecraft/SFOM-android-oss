package com.storeforminecraft.app.core.common.util

import java.time.format.DateTimeFormatter

enum class DateFormatType(val formatter: DateTimeFormatter) {
    YYYY_MM_DD(DateTimeFormatter.ofPattern("yyyy.MM.dd")),
    YYYY_MM_DD_HH_MM(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm")),
    FULL_DATETIME_KR(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분"));
}
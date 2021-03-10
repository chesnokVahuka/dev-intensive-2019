package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

fun Date.format(pattern: String = "HH:mm:ss dd:MM:yy" ) : String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))

    return dateFormat.format(this)
}

fun Date.humanizeDiff(date:Date) : String {
    val diff = Date().time - date.time

    return when(diff / 1000){
        0L,1L -> "только что"
        in 1L..45L -> "несколько секунд назад"
        in 45L..75L -> "минуту назад"
        in 75L..45L*60 -> " ${diff / 1000 / 60} минут назад"
        in 45L*60..75L*60 -> " час назад"
        in 75L*60..22L*60*60 -> "  ${diff / 1000 / 60 / 60} часов назад"
        in 22L*60*60..26L*60*60 -> "день назад"
        in 26L*60*60..360L*60*60*24 -> "${diff / 1000 / 60 / 60 / 24} дней назад"
        else -> "более года назад"
    }
 }

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.add(value:Int, timeUnits: TimeUnits = TimeUnits.SECOND) : Date {
var time = this.time

    time +=when(timeUnits){
        TimeUnits.SECOND-> value * SECOND
        TimeUnits.MINUTE-> value * MINUTE
        TimeUnits.HOUR-> value * HOUR
        TimeUnits.DAY-> value * DAY
    }
    this.time = time
    return this
}

enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY
}

package dev.lucasvillaverde.androidloginanimation.utils

import java.util.*


object DateUtils {

    val MORNING = 1
    val EVENING = 2

    fun getDayTimePeriod(): Int {
        val c: Calendar = Calendar.getInstance()
        val timeOfDay: Int = c.get(Calendar.HOUR_OF_DAY)

        if (timeOfDay in 0..15) {
            return MORNING
        } else if (timeOfDay in 16..23) {
            return EVENING
        }

        return MORNING
    }

}
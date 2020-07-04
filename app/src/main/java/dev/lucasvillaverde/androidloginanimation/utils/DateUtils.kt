package dev.lucasvillaverde.androidloginanimation.utils

import java.util.*


object DateUtils {

    const val MORNING = 1
    const val EVENING = 2

    fun getDayTimePeriod(): Int {
        val c: Calendar = Calendar.getInstance()
        val timeOfDay: Int = c.get(Calendar.HOUR_OF_DAY)

        if (timeOfDay in 5..15) {
            return MORNING
        } else if (timeOfDay in 16..23 || timeOfDay in 0..4) {
            return EVENING
        }

        return MORNING
    }

}
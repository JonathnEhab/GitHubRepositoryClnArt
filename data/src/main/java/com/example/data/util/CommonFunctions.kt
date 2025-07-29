package com.example.data.util

import com.example.domain.model.IssueState
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

fun mapToIssueState(state: String): IssueState {
    return when (state.lowercase(Locale.ROOT)) {
        "open" -> IssueState.Open
        else -> IssueState.Closes
    }
}

fun formatDateString(dateString: String): String {

    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
    val dateTime = LocalDateTime.parse(dateString, formatter)
    val zoneDateTime = dateTime.atZone(ZoneId.of("UTC"))
    val year = zoneDateTime.year
    val month = zoneDateTime.month
    val day = zoneDateTime.dayOfMonth
    val hour = zoneDateTime.hour
    val minute = zoneDateTime.minute

    val amPm = if (hour >= 12) "PM" else "AM"

    return "Created At : $year - $month - $day, $hour:$minute $amPm"
}
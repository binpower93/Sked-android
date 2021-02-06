@file:UseSerializers(DateAsStringSerializer::class)

package me.benbarber.sked.data.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import me.benbarber.sked.serializers.DateAsStringSerializer
import java.util.*

@Serializable
data class Event(
    val id: Int,
    val name: String,
    var start: Date,
    var end: Date,
)
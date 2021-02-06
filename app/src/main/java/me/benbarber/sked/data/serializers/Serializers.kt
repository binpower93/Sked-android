package me.benbarber.sked.serializers

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.format.DateTimeFormatter
import java.util.*

object DateAsStringSerializer : KSerializer<Date> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Date", PrimitiveKind.STRING)
    private val dateTimeFormatter = DateTimeFormatter.ISO_INSTANT

    override fun deserialize(decoder: Decoder): Date {
        println(dateTimeFormatter.format(Date().toInstant()))
        return Date.from(
            Instant.from(
                dateTimeFormatter.parse(decoder.decodeString())
            )
        )
    }

    override fun serialize(encoder: Encoder, value: Date) {
        encoder.encodeString(dateTimeFormatter.format(value.toInstant()))
    }
}
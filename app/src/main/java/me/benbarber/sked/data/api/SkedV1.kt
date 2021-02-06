package me.benbarber.sked.data.api

import me.benbarber.sked.data.models.Event
import retrofit2.Response
import retrofit2.http.GET

interface SkedV1 {
    @GET("/v1/event")
    suspend fun getEvents(): Response<List<Event>>
}
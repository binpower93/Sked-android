package me.benbarber.sked.data.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json
import me.benbarber.sked.data.models.Event
import okhttp3.MediaType
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.create
import java.lang.IllegalStateException

class SkedRepository(val v1Api: SkedV1) {

    fun getEvents(): Flow<List<Event>> {
        return flow {
            val response = v1Api.getEvents()
            if(response.isSuccessful) {
                emit(response.body().orEmpty())
            } else {
                throw IllegalStateException(response.errorBody()?.string().orEmpty())
            }
        }
    }

    companion object {
        @JvmStatic
        val INSTANCE = SkedRepository(
            v1Api = Retrofit.Builder()
                .baseUrl("http://192.168.0.18:8080/")
                .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
                .build()
                .create()
        )
    }
}
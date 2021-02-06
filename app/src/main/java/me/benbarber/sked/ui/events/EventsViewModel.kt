package me.benbarber.sked.ui.events

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import me.benbarber.sked.data.api.SkedRepository
import me.benbarber.sked.data.models.Event

class EventsViewModel(private val skedRepository: SkedRepository = SkedRepository.INSTANCE): ViewModel() {
    val loading = MutableLiveData<Boolean>()
    private val _events = MutableStateFlow(emptyList<Event>())
    val events = _events

    init {
        loading.value = true

        viewModelScope.launch {
            skedRepository.getEvents()
                .onStart { loading.postValue(true) }
                .onEach { loading.postValue(false) }
                .catch {
                    Log.e("EventsViewModel", "Failed to load events", it)
                }
                .flowOn(Dispatchers.IO)
                .collect {
                    Log.d("events", "$it")
                    _events.value = it
                }
        }
    }
}
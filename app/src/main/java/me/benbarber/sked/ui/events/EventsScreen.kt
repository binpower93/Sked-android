package me.benbarber.sked.ui.events

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.viewinterop.viewModel
import androidx.compose.runtime.getValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import me.benbarber.sked.data.models.Event


@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun EventsScreen(viewModel: EventsViewModel = viewModel()) {
    val events by viewModel.events.collectAsState()

    LazyColumn(content = {
        items(events) {
            EventRow(event = it)
        }
    })
}

@Composable
fun EventRow(event: Event) {
    Card {
        Column {
            Text(text = event.name)
            Text(text = "${event.start} to ${event.end}")
        }
    }
}
package com.example.retrofit

import android.annotation.SuppressLint
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material.*
import android.os.Bundle
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.retrofit.viewmodel.MyViewModel
import kotlin.reflect.KProperty

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MyViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppContent(viewModel)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppContent(viewModel: MyViewModel) {
    val hits by viewModel.wikiUiState.observeAsState(initial = 0)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Wikipedia Hits") },
                actions = {
                    IconButton(onClick = { viewModel.getHits("Trump") }) { // You can replace "Trump" with other president names for testing
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                }
            )
        }
    ) {
        Text(text = "Hits: $hits", modifier = Modifier.padding(16.dp))
    }
}


@Preview(showBackground = true)
@Composable
fun AppContentPreview() {
    val viewModel = MyViewModel()
    AppContent(viewModel)
}

package com.example.scrollling_swiping

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.scrollling_swiping.ui.theme.Scrollling_swipingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scrollling_swipingTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    GestureArea(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun GestureArea(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Box(
        modifier = modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectVerticalDragGestures { _, dragAmount ->
                    if (dragAmount > 0) {
                        Toast.makeText(context, "Скроллинг вниз", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Скроллинг вверх", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            .pointerInput(Unit) {
                detectHorizontalDragGestures { _, dragAmount ->
                    if (dragAmount > 0) {
                        Toast.makeText(context, "Свайп вправо", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Свайп влево", Toast.LENGTH_SHORT).show()
                    }
                }
            }
    ) {
        Text(
            text = "Свайпните влево/вправо или прокрутите вверх/вниз",
            modifier = Modifier.align(Alignment.Center),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GestureAreaPreview() {
    Scrollling_swipingTheme {
        GestureArea()
    }
}

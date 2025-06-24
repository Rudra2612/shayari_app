package com.example.app_4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app_4.ui.theme.App4Theme

class Lec : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App4Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                       /* LazyVerticalGrid(columns = GridCells.Fixed(3)) {
                            items(40) {
                                Image(
                                    painter = painterResource(R.drawable.ic_launcher_background), modifier = Modifier.padding(10.dp),
                                    contentDescription = null
                                )
                            }
                        }*/

                       /* LazyHorizontalGrid(rows = GridCells.Fixed(5)) {
                            items(40) {
                                Image(
                                    painter = painterResource(R.drawable.ic_launcher_background), modifier = Modifier.padding(10.dp),
                                    contentDescription = null
                                )
                            }
                        }*/

                        LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(3)) {
                            items(40) {
                                Image(
                                    painter = painterResource(R.drawable.ic_launcher_background), modifier = Modifier.padding(10.dp),
                                    contentDescription = null
                                )
                            }
                        }


                    }
                }
            }
        }
    }
}

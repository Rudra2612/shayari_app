package com.example.app_4

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app_4.ui.theme.App4Theme


class MainActivity : ComponentActivity() {

//    override fun onStart() {
//        super.onStart()
//        Log.d(TAG, "onStart: ")
//
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Log.d(TAG, "onStop: ")
//    }
//
//    override fun onRestart() {
//        super.onRestart()
//        Log.d(TAG, "onRestart: ")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        Log.d(TAG, "onResume: ")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Log.d(TAG, "onPause: ")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//
//        Log.d(TAG, "onDestroy: ")
//    }

    @SuppressLint("ResourceAsColor")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App4Theme {
                Scaffold(topBar = {
                    CenterAlignedTopAppBar(
                        title = {
                            Text(
                                text = "हिंदी शायरी",
                                fontFamily = FontFamily(Font(R.font.amita_bold)),
                                fontSize = 30.sp,
                            )
                        }, actions = {
                            Icon(
                                imageVector = Icons.Default.Favorite,
                                contentDescription = " ",
                                modifier = Modifier.clickable {
                                    val intent =
                                        Intent(this@MainActivity, MainActivity4::class.java)
                                    startActivity(intent)
                                }
                            )
                        }, colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color(0xFF024D2D)
                        )
                    )
                }) { paddingValues: PaddingValues ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                    ) {

                        val shayariCategories = arrayOf(
                            "प्रेम शायरी",
                            "दुःख शायरी",
                            "रोमांटिक शायरी",
                            "दोस्ती शायरी",
                            "क्रांतिकारी शायरी",
                            "अटिट्यूड शायरी",
                            "प्रेरणादायक शायरी",
                            "हंसी मजाक शायरी",
                            "दर्द शायरी",
                            "बेवफा शायरी",
                            "याद शायरी",
                            "इश्क शायरी",
                            "तनहाई शायरी",
                            "गुड मॉर्निंग शायरी",
                            "गुड नाइट शायरी",
                            "जन्मदिन शायरी",
                            "बारिश शायरी",
                            "जीवन शायरी",
                            "होली शायरी",
                            "ईद शायरी",
                            "नया साल शायरी",
                            "राजनीति शायरी",
                            "ब्रेकअप शायरी",
                            "दो लाइन दोस्ती शायरी",
                            "दो लाइन शायरी"
                        )

                        LazyColumn(
                            modifier = Modifier.background(color = Color(0xFFE2F8E6)),
                            contentPadding = PaddingValues(5.dp)
                        ) {
                            items(shayariCategories.size) {

                                Button(
                                    onClick = {
                                        val intent =
                                            Intent(this@MainActivity, MainActivity2::class.java)
                                        intent.putExtra("category", shayariCategories[it])
                                        startActivity(intent)
                                    },
                                    modifier = Modifier
                                        .height(60.dp)
                                        .fillMaxWidth()
                                        .padding(3.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(0xFFFFF7F7),
                                    ),
                                    border = BorderStroke(1.dp, color = Color(0xBE052269)),
                                    elevation = ButtonDefaults.buttonElevation(
                                        defaultElevation = 1.dp, pressedElevation = 5.dp
                                    ),
                                    contentPadding = PaddingValues(10.dp, 7.dp)
                                ) {
                                    Text(
                                        text = shayariCategories[it],
                                        fontSize = 25.sp,
                                        fontFamily = FontFamily(Font(R.font.biryani_extrabold)),
                                        color = Color(0xC8F667C6),
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(20.dp, 0.dp)
                                            .weight(4f)
                                    )

                                    Column(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .weight(1f),
                                        horizontalAlignment = Alignment.End,
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        Icon(
                                            painter = painterResource(R.drawable.angle_right),
                                            contentDescription = "",
                                            tint = Color.Gray
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
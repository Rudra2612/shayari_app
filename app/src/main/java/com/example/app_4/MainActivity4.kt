package com.example.app_4

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app_4.ui.theme.App4Theme
import com.example.app_4.ui.theme.Button1
import com.example.app_4.ui.theme.CopyShareWhatsApp
import androidx.core.content.edit


class MainActivity4 : ComponentActivity() {

    private var fShayariList by mutableStateOf(arrayOf<String>())
    private lateinit var favoriteShayari: HashSet<String>

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sp = getSharedPreferences("favorite_shayari", MODE_PRIVATE)
        favoriteShayari = HashSet(sp.getStringSet("fshayari", hashSetOf<String>())!!)
        fShayariList = favoriteShayari.toTypedArray()

        enableEdgeToEdge()
        setContent {
            App4Theme {

                val context = LocalContext.current

                Scaffold(topBar = {
                    CenterAlignedTopAppBar(
                        title = {
                            Text(
                                text = "पसंदीदा शायरी",
                                fontFamily = FontFamily(Font(R.font.amita_bold)),
                                fontSize = 30.sp,
                                color = Color(0xE1CB2092)
                            )
                        }, navigationIcon = {
                            IconButton(onClick = {
                                (context as? Activity)?.finish()
                            }) {
                                Icon(
                                    modifier = Modifier
                                        .height(30.dp)
                                        .width(30.dp),
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = ""
                                )
                            }
                        }, colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color(0xD577D5B2)
                        )
                    )
                }) { innerPadding ->

                    if (fShayariList.isNotEmpty()) {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding)
                                .background(color = Color(0xFFE2F8E6)),
                            contentPadding = PaddingValues(5.dp)
                        ) {
                            items(fShayariList.size) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(3.dp, 10.dp)
                                        .background(color = Color(0x8174E8EC))
                                ) {

                                    Text(
                                        text = fShayariList[it],
                                        fontSize = 20.sp,
                                        fontFamily = FontFamily(Font(R.font.playpensansdeva_medium)),
                                        color = Color.Black,
                                        lineHeight = 27.sp
                                    )

                                    Row(
                                        modifier = Modifier
                                            .height(45.dp)
                                            .background(
                                                color = Color(0x9200ACC1)
                                            )
                                    ) {
                                        Button1(
                                            Color.Red, R.drawable.heart1, this
                                        ) {
                                            favoriteShayari.remove(fShayariList[it])

                                            sp.edit {
                                                putStringSet("fshayari", favoriteShayari)
                                                apply()
                                            }

                                            fShayariList = favoriteShayari.toTypedArray()
                                        }
                                        Button1(Color.Black, R.drawable.eye, this) {
                                            val intent = Intent(
                                                context, MainActivity5::class.java
                                            )
                                            intent.putExtra("shayari", fShayariList[it])
                                            startActivity(intent)
                                        }
                                        CopyShareWhatsApp(fShayariList[it], context, this)
                                    }
                                }
                            }
                        }
                    } else {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding)
                                .background(color = Color(0xFFE2F8E6)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                "पसंदीदा शायरी\nNot Found!!",
                                fontWeight = FontWeight.ExtraBold,
                                letterSpacing = 2.sp,
                                fontSize = 50.sp,
                                lineHeight = 50.sp,
                                color = Color(0xFFD796C1),
                                textAlign = TextAlign.Center
                            )
                        }
                    }

                }
            }
        }
    }
}


/*val sharedPreferences = getSharedPreferences("MY_PREFS", MODE_PRIVATE)
val savedText = sharedPreferences.getString(
    "favorite_text", ""
)*/
/*if (savedText!!.isEmpty()) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(color = Color(0xFFE2F8E6)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            "पसंदीदा शायरी\nNot Found!!",
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = 2.sp,
            fontSize = 50.sp,
            lineHeight = 50.sp,
            color = Color(0x3BCB2092),
            textAlign = TextAlign.Center
        )
    }
    return@Scaffold
}

var shayariList by remember { mutableStateOf(savedText.split("_0_")) }*/
/*shayariList = shayariList.minusElement(shayariList[it])
val newShayari =
    shayariList.joinToString(separator = "_0_")
sharedPreferences.edit {
    putString(
        "favorite_text", newShayari
    )
}*/
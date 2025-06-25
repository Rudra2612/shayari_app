package com.example.app_4

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app_4.ui.theme.App4Theme
import com.example.app_4.ui.theme.Button1
import com.example.app_4.ui.theme.CopyShareWhatsApp
import androidx.core.content.edit


class MainActivity2 : ComponentActivity() {

    private val sp: SharedPreferences by lazy {
        getSharedPreferences("favorite_shayari", MODE_PRIVATE)
    }
    private lateinit var favoriteShayari: HashSet<String>


    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App4Theme {

                val context = LocalContext.current
                favoriteShayari = HashSet(sp.getStringSet("fshayari", hashSetOf<String>())!!)

                val category = intent.getStringExtra("category") ?: "Not Found"

                Scaffold(topBar = {
                    CenterAlignedTopAppBar(
                        title = {
                            Text(
                                text = category,
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

                    Column(modifier = Modifier.padding(innerPadding)) {

                        var shayari = emptyArray<String>()

                        when (category) {
                            "प्रेम शायरी" -> {
                                shayari = premShayari
                            }

                            "दुःख शायरी" -> {
                                shayari = dukhShayari
                            }

                            "रोमांटिक शायरी" -> {
                                shayari = romanticShayari
                            }

                            "दोस्ती शायरी" -> {
                                shayari = dostiShayari
                            }

                            "क्रांतिकारी शायरी" -> {
                                shayari = krantikariShayari
                            }

                            "अटिट्यूड शायरी" -> {
                                shayari = attitudeShayari
                            }

                            "प्रेरणादायक शायरी" -> {
                                shayari = preranaShayari
                            }

                            "हंसी मजाक शायरी" -> {
                                shayari = hasiMazaakShayari
                            }

                            "दर्द शायरी" -> {
                                shayari = dardShayari
                            }

                            "बेवफा शायरी" -> {
                                shayari = bewafaShayari
                            }

                            "याद शायरी" -> {
                                shayari = yaadShayari
                            }

                            "इश्क शायरी" -> {
                                shayari = ishqShayari
                            }

                            "तनहाई शायरी" -> {
                                shayari = tanhaiShayari
                            }

                            "गुड मॉर्निंग शायरी" -> {
                                shayari = goodMorningShayari
                            }

                            "गुड नाइट शायरी" -> {
                                shayari = goodNightShayari
                            }

                            "जन्मदिन शायरी" -> {
                                shayari = janmdinShayari
                            }

                            "बारिश शायरी" -> {
                                shayari = barishShayari
                            }

                            "जीवन शायरी" -> {
                                shayari = jeevanShayari
                            }

                            "होली शायरी" -> {
                                shayari = holiShayari
                            }

                            "ईद शायरी" -> {
                                shayari = eidShayari
                            }

                            "नया साल शायरी" -> {
                                shayari = nayaSaalShayari
                            }

                            "राजनीति शायरी" -> {
                                shayari = rajnitiShayari
                            }

                            "ब्रेकअप शायरी" -> {
                                shayari = breakupShayari
                            }

                            "दो लाइन दोस्ती शायरी" -> {
                                shayari = doLineDostiShayari
                            }

                            "दो लाइन शायरी" -> {
                                shayari = doLineShayari
                            }
                        }


                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color = Color(0xFFE2F8E6)),
                            contentPadding = PaddingValues(5.dp)
                        ) {
                            items(shayari.size) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(3.dp, 10.dp)
                                        .background(color = Color(0x8174E8EC))
                                ) {
                                    Row(modifier = Modifier.clickable {
                                        val intent = Intent(
                                            context, MainActivity3::class.java
                                        )
                                        intent.putExtra("category", category)
                                        intent.putExtra("shayari", shayari)
                                        intent.putExtra("shayarinumber", it)
                                        intent.putExtra("totalshayari", shayari.size)
                                        startActivity(intent)
                                        finish()
                                    }) {
                                        Text(
                                            text = shayari[it],
                                            fontSize = 20.sp,
                                            fontFamily = FontFamily(Font( R.font.playpensansdeva_medium)),
                                            color = Color.Black,
                                            lineHeight = 27.sp
                                        )
                                    }
                                    Row(
                                        modifier = Modifier
                                            .height(45.dp)
                                            .background(
                                                color = Color(0x9200ACC1)
                                            )
                                    ) {
                                        var isFavorite: Boolean by remember {
                                            mutableStateOf(
                                                favoriteShayari.contains(shayari[it])
                                            )
                                        }
                                        Button1(
                                            if (isFavorite) Color.Red else Color.Black,
                                            if (isFavorite) R.drawable.heart1 else R.drawable.heart,
                                            this
                                        ) {
                                            if (isFavorite) {
                                                favoriteShayari.remove(shayari[it])
                                            } else {
                                                favoriteShayari.add(shayari[it])
                                            }
                                            isFavorite = !isFavorite
                                            sp.edit {
                                                putStringSet("fshayari", favoriteShayari)
                                                apply()
                                            }
                                        }
                                        Button1(Color.Black, R.drawable.eye, this) {
                                            val intent = Intent(
                                                context, MainActivity5::class.java
                                            )
                                            intent.putExtra("shayari", shayari[it])
                                            startActivity(intent)
                                        }
                                        CopyShareWhatsApp(shayari[it], context, this)
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

/*
val sharedPreferences = getSharedPreferences("MY_PREFS", MODE_PRIVATE)
val savedText = sharedPreferences.getString(
    "favorite_text", ""
)

val newShayari = if (savedText!!.isNotEmpty()) {
    val shayariList = savedText.split("_0_")
    val shayariList1 = shayariList.toMutableList()
        .apply { add(shayari[it]) }
    shayariList1.joinToString(separator = "_0_")
} else {
    shayari[it]
}
sharedPreferences.edit {
    putString(
        "favorite_text", newShayari
    )
}*/

package com.example.app_4

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app_4.ui.theme.App4Theme
import com.example.app_4.ui.theme.Button1
import com.example.app_4.ui.theme.CopyShareWhatsApp
import androidx.core.content.edit


@Suppress("DEPRECATION")
class MainActivity3 : ComponentActivity() {

    private val sp: SharedPreferences by lazy {
        getSharedPreferences("favorite_shayari", MODE_PRIVATE)
    }
    private lateinit var favoriteShayari: HashSet<String>
    private lateinit var category: String

    @SuppressLint("UseKtx")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App4Theme {

                val context = LocalContext.current
                favoriteShayari = HashSet(sp.getStringSet("fshayari", hashSetOf<String>())!!)


                category = intent.getStringExtra("category") ?: "Not Found"
                val shayari = intent.getStringArrayExtra("shayari") ?: arrayOf("Not Found")
                val totalshayari = intent.getIntExtra("totalshayari", 0)
                var shayarino by remember {
                    mutableIntStateOf(
                        intent.getIntExtra(
                            "shayarinumber", 0
                        )
                    )
                }

                Scaffold(topBar = {
                    CenterAlignedTopAppBar(
                        title = {}, navigationIcon = {
                            IconButton(onClick = {
                                onBackPressed()
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

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .background(color = Color(0xFFE2F8E6)),
                        verticalArrangement = Arrangement.Center
                    ) {
                        var isFavorite: Boolean by remember {
                            mutableStateOf(
                                favoriteShayari.contains(
                                    shayari[shayarino]
                                )
                            )
                        }
                        isFavorite = favoriteShayari.contains(
                            shayari[shayarino]
                        )
                        Text(
                            text = shayari[shayarino],
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.playpensansdeva_medium)),
                            color = Color.Black,
                            lineHeight = 27.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp)
                                .background(color = Color(0x8174E8EC))
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(45.dp)
                                .padding(horizontal = 10.dp)
                                .background(
                                    color = Color(0x9200ACC1)
                                )
                        ) {
                            Button1(
                                if (isFavorite) Color.Red else Color.Black,
                                if (isFavorite) R.drawable.heart1 else R.drawable.heart,
                                this
                            ) {
                                if (isFavorite) {
                                    favoriteShayari.remove(shayari[shayarino])
                                } else {
                                    favoriteShayari.add(shayari[shayarino])
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
                                intent.putExtra("shayari", shayari[shayarino])
                                startActivity(intent)
                            }
                            CopyShareWhatsApp(shayari[shayarino], context, this)
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(bottom = 40.dp),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        ArrowButton(Icons.AutoMirrored.Filled.ArrowBack) {
                            if (shayarino > 0) {
                                shayarino--
                            } else {
                                Toast.makeText(
                                    this@MainActivity3, "First Shayari", Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                        ArrowButton(Icons.AutoMirrored.Filled.ArrowForward) {
                            if (shayarino < totalshayari - 1) {
                                shayarino++
                            } else {
                                Toast.makeText(
                                    this@MainActivity3, "Last Shayari", Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun ArrowButton(imageVector: ImageVector, onclick: () -> Unit) {
        Button(
            onClick = onclick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0x9200ACC1)
            ),
            modifier = Modifier.size(width = 90.dp, height = 50.dp),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(2.dp, color = Color(0xFF0FB1C5))
        ) {
            Icon(
                imageVector = imageVector,
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
        }
    }

    @Deprecated("This method has been deprecated in favor of using the\n      {@link OnBackPressedDispatcher} via {@link #getOnBackPressedDispatcher()}.\n      The OnBackPressedDispatcher controls how back button events are dispatched\n      to one or more {@link OnBackPressedCallback} objects.")
    override fun onBackPressed() {
        super.onBackPressed()

        val intent = Intent(
            this@MainActivity3, MainActivity2::class.java
        )
        intent.putExtra("category", category)

        startActivity(intent)
        finish()
    }
}

/*val sharedPreferences = getSharedPreferences("MY_PREFS", MODE_PRIVATE)
val savedText = sharedPreferences.getString(
    "favorite_text", ""
)

val newShayari = if (savedText!!.isNotEmpty()) {
    val shayariList = savedText.split("_0_")
    val hh = shayariList.toMutableList()
        .apply { add(shayari[shayarino]) }
    hh.joinToString(separator = "_0_")
} else {
    shayari[shayarino]
}
sharedPreferences.edit {
    putString(
        "favorite_text", newShayari
    )
}*/

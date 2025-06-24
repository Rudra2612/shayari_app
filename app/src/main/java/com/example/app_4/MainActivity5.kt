package com.example.app_4

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.example.app_4.ui.theme.App4Theme
import com.example.app_4.ui.theme.ColorList
import io.mhssn.colorpicker.ColorPickerDialog
import io.mhssn.colorpicker.ColorPickerType


class MainActivity5 : ComponentActivity() {

    private var type by mutableStateOf(Select.NONE)
    private var bgtype by mutableStateOf(true)
    private var ftype by mutableStateOf(Fonts.FCOLOR)
    private var bgcolor by mutableStateOf(ColorList[2])

    //    private var bgimage by mutableIntStateOf(BgImages[0])
    private var fcolor by mutableStateOf(ColorList[0])
    private var fsize by mutableFloatStateOf(20f)
    private var ffamily by mutableIntStateOf(Ffamily[0])
    private var fweight by mutableStateOf(Fweight[0])
    private var isShowColorPicker by mutableStateOf(false)


    @OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            App4Theme {

                val context = LocalContext.current
                val shayari = intent.getStringExtra("shayari") ?: "Not Found"


                Scaffold(topBar = {
                    CenterAlignedTopAppBar(
                        title = {}, navigationIcon = {
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

                    ColorPickerDialog(
                        show = isShowColorPicker,
                        type = ColorPickerType.Circle(),
                        properties = DialogProperties(dismissOnClickOutside = true),
                        onDismissRequest = {
                            isShowColorPicker = false
                        },
                        onPickedColor = {
                            isShowColorPicker = false
                            if(type == Select.BACKGROUND) {
                                bgcolor = it
                            } else {
                                fcolor = it
                            }
                        },
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .background(color = Color(0xFFE2F8E6)),
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Box {
                                val lineh = fsize + 12
                                Text(
                                    text = shayari,
                                    fontSize = fsize.sp,
                                    fontFamily = FontFamily(Font(ffamily)),
                                    color = fcolor,
                                    fontWeight = fweight,
                                    lineHeight = lineh.sp,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 10.dp)
                                        .background(color = bgcolor)
                                )
                            }
                        }

                        when (type) {
                            Select.NONE -> FontBg()
                            Select.FONT -> Font()
                            Select.BACKGROUND -> Background()
                        }
                    }
                }
            }
        }
    }


    @Composable
    fun FontBg() {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 30.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            MyButton("Background") {
                type = Select.BACKGROUND
            }
            MyButton("Font") {
                type = Select.FONT
            }
        }
    }

    @Composable
    fun MyButton(text: String, onClick: () -> Unit) {
        Button(
            onClick = onClick,
            modifier = Modifier.size(width = 150.dp, height = 50.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF52BBA0)
            ),
            border = BorderStroke(2.dp, Color(0xFF69D3A0))
        ) {
            Text(text, fontSize = 19.sp)
        }
    }

    @Composable
    fun Font() {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 30.dp),
            verticalAlignment = Alignment.Bottom,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color(0xFF303130))
            ) {
                LazyRow {
                    item {
                        IconButton(onClick = {
                            type = Select.NONE
                            ftype = Fonts.FCOLOR
                        }) {
                            Icon(imageVector = Icons.Default.Close, contentDescription = null)
                        }
                        TextButtons("Color") {
                            ftype = Fonts.FCOLOR
                        }
                        TextButtons("Size") {
                            ftype = Fonts.FSIZE
                        }
                        TextButtons("Family") {
                            ftype = Fonts.FFAMILY
                        }
                        TextButtons("Weight") {
                            ftype = Fonts.FWEIGHT
                        }
                    }
                }
                when (ftype) {
                    Fonts.FCOLOR -> {
                        Color1(false)
                    }

                    Fonts.FSIZE -> {
                        Slider(
                            fsize,
                            onValueChange = { fsize = it },
                            valueRange = 15f..35f,
                            modifier = Modifier.padding(horizontal = 20.dp)
                        )
                    }

                    Fonts.FFAMILY -> {
                        LazyRow {
                            items(Ffamily.size) {
                                Card(
                                    modifier = Modifier
                                        .size(70.dp)
                                        .padding(5.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color.White
                                    ),
                                    border = BorderStroke(2.dp, color = Color(0x8A292F2A)),
                                    onClick = {
                                        ffamily = Ffamily[it]
                                    }) {
                                    Text(
                                        "आ",
                                        fontSize = 25.sp,
                                        textAlign = TextAlign.Center,
                                        color = Color.Black,
                                        fontFamily = FontFamily(
                                            Font(
                                                Ffamily[it]
                                            )
                                        ),
                                        modifier = Modifier.padding(10.dp)
                                    )
                                }
                            }
                        }
                    }

                    Fonts.FWEIGHT -> {
                        LazyRow {
                            items(Fweight.size) {
                                Card(
                                    modifier = Modifier
                                        .size(70.dp)
                                        .padding(5.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color.White
                                    ),
                                    border = BorderStroke(2.dp, color = Color(0x8A292F2A)),
                                    onClick = {
                                        fweight = Fweight[it]
                                    }) {
                                    Text(
                                        "आ",
                                        fontSize = 25.sp,
                                        fontWeight = Fweight[it],
                                        textAlign = TextAlign.Center,
                                        color = Color.Black,
                                        modifier = Modifier.padding(10.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }

        }
    }

    @Composable
    fun Background() {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 30.dp),
            verticalAlignment = Alignment.Bottom,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color(0xFF303130))
            ) {
                LazyRow {
                    item {
                        IconButton(onClick = {
                            type = Select.NONE
                            bgtype = true
                        }) {
                            Icon(imageVector = Icons.Default.Close, contentDescription = null)
                        }
                        TextButtons("bgColor") {
                            bgtype = true
                        }
                        TextButtons("bgImage") {
                            bgtype = false
                        }
                    }
                }
                if (bgtype) {
                    Color1(true)
                } else {
                    LazyRow {
                        items(BgImages.size) {
                            Card(
                                modifier = Modifier
                                    .size(70.dp)
                                    .padding(5.dp),
                                border = BorderStroke(2.dp, color = Color(0x2CD0E7D7))
                            ) {
                                Image(
                                    painter = painterResource(BgImages[it]),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun Color1(bg: Boolean) {
        LazyRow {
            item {
                Card(
                    modifier = Modifier
                        .size(70.dp)
                        .padding(5.dp), colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    border = BorderStroke(2.dp, color = Color(0x2CD0E7D7)),
                    onClick = {
                        isShowColorPicker = true
                    }
                ) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = null,
                        modifier = Modifier.padding(20.dp)
                    )
                }
            }
            items(ColorList.size) {
                Card(
                    modifier = Modifier
                        .size(70.dp)
                        .padding(5.dp), colors = CardDefaults.cardColors(
                        containerColor = ColorList[it]
                    ), border = BorderStroke(2.dp, color = Color(0x2CD0E7D7)), onClick = {
                        if (bg) {
                            bgcolor = ColorList[it]
                        } else {
                            fcolor = ColorList[it]
                        }
                    }) {
                    if (bg && bgcolor == ColorList[it]) {
                        Icon(imageVector = Icons.Default.Check, contentDescription = null)
                    }
                    if (!bg && fcolor == ColorList[it]) {
                        Icon(imageVector = Icons.Default.Check, contentDescription = null)
                    }/*if ((bg && bgcolor == ColorList[it]) || (!bg && fcolor == ColorList[it])) {
                        Icon(Icons.Default.Check, contentDescription = null)
                    }*/
                }
            }
        }
    }

    @Composable
    fun TextButtons(text: String, onClick: () -> Unit) {
        TextButton(onClick = onClick) {
            Text(
                text, fontSize = 20.sp, color = Color(0xD574DAB4),
            )
        }
    }
}


enum class Select {
    NONE, FONT, BACKGROUND
}

enum class Fonts {
    FCOLOR, FSIZE, FFAMILY, FWEIGHT
}
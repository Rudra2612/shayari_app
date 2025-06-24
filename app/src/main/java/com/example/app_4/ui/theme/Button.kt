@file:Suppress("DEPRECATION")

package com.example.app_4.ui.theme

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.example.app_4.R

@Composable
fun Button1(color: Color, painter: Int, rowScope: RowScope, clickable: () -> Unit) {
    rowScope.apply {
        Column(
            modifier = Modifier
                .clickable(onClick = clickable)
                .fillMaxSize()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(painter), contentDescription = "", tint = color
            )
        }
    }
}

@Composable
fun CopyShareWhatsApp(shayari: String, context: Context, rowScope: RowScope) {
    rowScope.apply {
        Button1(
            Color.Black, R.drawable.copy, this
        ) {
            val clipboardManager = ContextCompat.getSystemService(context, ClipboardManager::class.java)
            val clip = ClipData.newPlainText(
                "label", shayari
            )
            clipboardManager?.setPrimaryClip(clip)
            Toast.makeText(
                context, "copied!!", Toast.LENGTH_SHORT
            ).show()
        }
        Button1(
            Color.Black, R.drawable.share, this
        ) {
            val sendIntent = Intent(Intent.ACTION_SEND)
            sendIntent.putExtra(
                Intent.EXTRA_TEXT, shayari
            )
            sendIntent.setType("text/plain")
            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(context,shareIntent, Bundle())
        }
        Button1(
            Color(0xFF34B726), R.drawable.whatsapp, this
        ) {
            val whatsappIntent = Intent(Intent.ACTION_SEND)
            whatsappIntent.setType("text/plain")
            whatsappIntent.setPackage("com.whatsapp")
            whatsappIntent.putExtra(
                Intent.EXTRA_TEXT, shayari
            )
            startActivity(context,whatsappIntent, Bundle())
        }
    }
}
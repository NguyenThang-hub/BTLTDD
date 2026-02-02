package com.example.btltdd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // ✅ Bọc MaterialTheme để Material3 hoạt động ổn định
            MaterialTheme {
                Surface {
                    BusinessCardScreen(
                        name = "Nguyễn Viết Chiến Thắng",
                        title = "Android Developer",
                        phone = "0935367234",
                        social = "fb:Nguyễn Thắng",
                        email = "luckychannel530@gmail.com",
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCardScreen(
    name: String,
    title: String,
    phone: String,
    social: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF0E3B2E))
            .padding(16.dp)
    ) {
        ProfileSection(
            name = name,
            title = title,
            modifier = Modifier.align(Alignment.Center)
        )

        ContactSection(
            phone = phone,
            social = social,
            email = email,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
        )
    }
}

@Composable
fun ProfileSection(
    name: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = name,
            fontSize = 26.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White
        )

        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF7DFFB2),
            modifier = Modifier.padding(top = 6.dp)
        )
    }
}

@Composable
fun ContactSection(
    phone: String,
    social: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        ContactRow(icon = Icons.Filled.Phone, text = phone)
        ContactRow(icon = Icons.Filled.Share, text = social)
        ContactRow(icon = Icons.Filled.Email, text = email)
    }
}

@Composable
fun ContactRow(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    text: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF7DFFB2),
            modifier = Modifier.size(22.dp)
        )
        Spacer(modifier = Modifier.width(14.dp))
        Text(text = text, color = Color.White, fontSize = 16.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    MaterialTheme {
        BusinessCardScreen(
            name = "Nguyễn Viết Chiến Thắng",
            title = "Android Developer",
            phone = "+84 912 345 678",
            social = "@Nguyễn Viết Chiến Thắng DEV",
            email = "luckychannel530@gmail.com"
        )
    }
}

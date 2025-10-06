package com.example.btvn_lhd_07_10

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.btvn_lhd_07_10.ui.theme.BTVN_LHD_07_10Theme

@Composable
fun ProfileScreen(account: Account, onSettingClick: () -> Unit, onBackClick: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF6EB5FF)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top bar với Back, Profile title và Setting icon
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(36.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "< Back",
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier.clickable { onBackClick() }
            )
            
            Spacer(modifier = Modifier.weight(1f))
            
            Text(
                text = "Profile",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            
            Spacer(modifier = Modifier.weight(1f))
            
            Icon(
                painter = painterResource(android.R.drawable.ic_menu_manage),
                contentDescription = "Setting",
                tint = Color.White,
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onSettingClick() }
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Avatar với badge số 3
        Box(
            modifier = Modifier.size(100.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(90.dp)
                    .background(Color.White, shape = CircleShape)
                    .border(3.dp, Color.White, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(android.R.drawable.ic_menu_myplaces),
                    contentDescription = "Avatar",
                    tint = Color(0xFF6EB5FF),
                    modifier = Modifier.size(50.dp)
                )
            }
            
            // Badge số 3
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .background(Color.Red, shape = CircleShape)
                    .size(24.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "3",
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        
        Spacer(modifier = Modifier.height(12.dp))
        
        // Tên profile
        Text(
            text = if (account.username.isNotBlank()) account.username else "Profile Name",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Thống kê Friends và Followers
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "125",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Friends",
                    color = Color.White,
                    fontSize = 14.sp
                )
            }
            
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "250",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Followers",
                    color = Color.White,
                    fontSize = 14.sp
                )
            }
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        
        // Card thông tin liên hệ
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                ContactInfoRow("email", account.email.ifBlank { "mail@email.com" })
                ContactInfoRow("Phone", account.phone.ifBlank { "+99 999 555 222" })
                ContactInfoRow("Skype", account.skype.ifBlank { "me007" })
                ContactInfoRow("Web", account.web.ifBlank { "cssauthor.com/" })
            }
        }
    }
}

@Composable
private fun ContactInfoRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$label : ",
            fontSize = 16.sp,
            color = Color(0xFF6EB5FF),
            fontWeight = FontWeight.Medium
        )
        Text(
            text = value,
            fontSize = 16.sp,
            color = Color.Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    BTVN_LHD_07_10Theme {
        ProfileScreen(
            account = Account(
                username = "Profile Name",
                email = "ledung@email.com",
                phone = "+99 999 555 222",
                skype = "me007",
                web = "cssauthor.com/"
            ),
            onSettingClick = {},
            onBackClick = {}
        )
    }
}
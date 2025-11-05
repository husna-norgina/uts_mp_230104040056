package id.antasari.uts_mp_230104040056.screens

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileSummaryScreen(
    navController: NavController,
    nama: String,
    kelas: String,
    hobi: String,
    darkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit
) {
    val context = LocalContext.current
    // State untuk mode gelap
    var darkMode by remember { mutableStateOf(darkTheme) }

    // Warna label menyesuaikan tema (hitam di terang, putih di gelap)
    val labelColor = MaterialTheme.colorScheme.onSurface

    Scaffold(
        topBar = {
            // Top App Bar
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Ringkasan Profil",
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            )
        }
    ) { padding ->
        // Column utama untuk menampung seluruh konten
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            MaterialTheme.colorScheme.primary.copy(alpha = 0.15f),
                            MaterialTheme.colorScheme.secondary.copy(alpha = 0.1f)
                        )
                    )
                )
                .padding(padding)
                .padding(horizontal = 20.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Card menampilkan ringkasan profil
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                elevation = CardDefaults.cardElevation(8.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
                Column(modifier = Modifier.padding(24.dp)) {
                    // Tampilkan Nama
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "Nama:",
                            fontWeight = FontWeight.Normal,
                            color = labelColor,
                            modifier = Modifier.width(70.dp),
                            textAlign = TextAlign.Start
                        )
                        Text(
                            nama,
                            style = MaterialTheme.typography.bodyLarge,
                            textAlign = TextAlign.Start
                        )
                    }
                    Spacer(Modifier.height(8.dp))

                    // Tampilkan Kelas
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "Kelas:",
                            fontWeight = FontWeight.Normal,
                            color = labelColor,
                            modifier = Modifier.width(70.dp),
                            textAlign = TextAlign.Start
                        )
                        Text(
                            kelas,
                            style = MaterialTheme.typography.bodyLarge,
                            textAlign = TextAlign.Start
                        )
                    }
                    Spacer(Modifier.height(8.dp))

                    // Tampilkan Hobi
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "Hobi:",
                            fontWeight = FontWeight.Normal,
                            color = labelColor,
                            modifier = Modifier.width(70.dp),
                            textAlign = TextAlign.Start
                        )
                        Text(
                            hobi,
                            style = MaterialTheme.typography.bodyLarge,
                            textAlign = TextAlign.Start
                        )
                    }
                }
            }

            Spacer(Modifier.height(12.dp))

            // Row untuk toggle Light/Dark mode
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Aktifkan Mode Gelap", style = MaterialTheme.typography.bodyLarge)
                Spacer(Modifier.width(8.dp))
                Switch(
                    checked = darkMode,
                    onCheckedChange = {
                        darkMode = it
                        onThemeChange(it)
                    },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = MaterialTheme.colorScheme.primary,
                        checkedTrackColor = MaterialTheme.colorScheme.secondary
                    )
                )
            }

            Spacer(Modifier.height(16.dp))

            // Tombol untuk menyimpan data ke SharedPreferences
            Button(
                onClick = {
                    saveToPreferences(context, nama, kelas, hobi, darkMode)
                    navController.navigate("saved") // Navigasi ke layar pengaturan tersimpan
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    "Simpan ke Perangkat",
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

// Fungsi untuk menyimpan data profil ke SharedPreferences
fun saveToPreferences(
    context: Context,
    nama: String,
    kelas: String,
    hobi: String,
    darkMode: Boolean
) {
    val prefs = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
    prefs.edit().apply {
        putString("nama", nama)
        putString("kelas", kelas)
        putString("hobi", hobi)
        putBoolean("darkMode", darkMode)
        apply()
    }
}

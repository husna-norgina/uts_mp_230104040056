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
fun SavedSettingsScreen(navController: NavController) {
    val context = LocalContext.current
    // Ambil data dari SharedPreferences
    val prefs = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    val nama = prefs.getString("nama", null)
    val kelas = prefs.getString("kelas", null)
    val hobi = prefs.getString("hobi", null)
    val darkMode = prefs.getBoolean("darkMode", false)

    // Warna label menyesuaikan tema (hitam di terang, putih di gelap)
    val labelColor = MaterialTheme.colorScheme.onSurface

    Scaffold(
        topBar = {
            // Top App Bar
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Pengaturan Tersimpan",
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            )
        }
    ) { padding ->
        // Box utama untuk background dan padding
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
                            MaterialTheme.colorScheme.secondary.copy(alpha = 0.05f)
                        )
                    )
                )
                .padding(padding)
                .padding(horizontal = 20.dp, vertical = 10.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Jika belum ada data, tampilkan pesan
                if (nama == null) {
                    Text(
                        "Belum ada data, silakan isi profil dulu",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                } else {
                    // Card untuk menampilkan data profil
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        shape = RoundedCornerShape(16.dp),
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
                                    nama ?: "N/A",
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
                                    kelas ?: "N/A",
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
                                    hobi ?: "N/A",
                                    style = MaterialTheme.typography.bodyLarge,
                                    textAlign = TextAlign.Start
                                )
                            }

                            Spacer(Modifier.height(12.dp))

                            // Tampilkan Mode Aplikasi (Dark/Light)
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    "Mode:",
                                    fontWeight = FontWeight.Normal,
                                    color = labelColor,
                                    modifier = Modifier.width(70.dp),
                                    textAlign = TextAlign.Start
                                )
                                Text(
                                    if (darkMode) "Gelap" else "Terang",
                                    style = MaterialTheme.typography.bodyLarge,
                                    textAlign = TextAlign.Start
                                )
                            }
                        }
                    }
                }

                Spacer(Modifier.height(28.dp))

                // Tombol kembali ke form
                Button(
                    onClick = { navController.navigate("form") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Text(
                        "Kembali ke Form",
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
    }
}

package id.antasari.uts_mp_230104040056.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileFormScreen(navController: NavController) {
    // State untuk inputan form
    var nama by remember { mutableStateOf("") }
    var kelas by remember { mutableStateOf("") }
    var hobi by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Form Profil", // Judul halaman
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        // Warna background gradien
                        colors = listOf(
                            MaterialTheme.colorScheme.primary.copy(alpha = 0.15f),
                            MaterialTheme.colorScheme.secondary.copy(alpha = 0.1f)
                        )
                    )
                )
                .padding(padding)
                .padding(20.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top, // Form berada di atas
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Kartu form profil
                Card(
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(8.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        // Input Nama
                        OutlinedTextField(
                            value = nama,
                            onValueChange = { nama = it },
                            label = { Text("Nama Lengkap") },
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(Modifier.height(8.dp)) // Jarak antar input

                        // Input Kelas
                        OutlinedTextField(
                            value = kelas,
                            onValueChange = { kelas = it },
                            label = { Text("Kelas") },
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(Modifier.height(8.dp)) // Jarak antar input

                        // Input Hobi
                        OutlinedTextField(
                            value = hobi,
                            onValueChange = { hobi = it },
                            label = { Text("Hobi") },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }

                Spacer(Modifier.height(16.dp)) // Jarak antara form dan tombol

                // Tombol Simpan & Lanjut
                Button(
                    onClick = {
                        // Navigasi ke halaman ringkasan jika semua field diisi
                        if (nama.isNotEmpty() && kelas.isNotEmpty() && hobi.isNotEmpty()) {
                            navController.navigate("summary/$nama/$kelas/$hobi")
                        }
                    },
                    modifier = Modifier.fillMaxWidth(), // Lebar tombol penuh
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(
                        "Simpan & Lanjut", // Teks tombol
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

package id.antasari.uts_mp_230104040056

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import id.antasari.uts_mp_230104040056.screens.ProfileFormScreen
import id.antasari.uts_mp_230104040056.screens.ProfileSummaryScreen
import id.antasari.uts_mp_230104040056.screens.SavedSettingsScreen
import id.antasari.uts_mp_230104040056.ui.theme.UTS_MP_230104040056Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // State global untuk mode gelap/terang
            var darkTheme by remember { mutableStateOf(false) }
            val navController = rememberNavController()

            UTS_MP_230104040056Theme(darkTheme = darkTheme) {
                Scaffold(
                    // Bottom Navigation Bar
                    bottomBar = { BottomNavBar(navController) }
                ) { padding ->
                    // Host navigasi dengan padding dari Scaffold
                    AppNavHost(
                        navController = navController,
                        darkTheme = darkTheme,
                        onThemeChange = { darkTheme = it },
                        modifier = Modifier.padding(padding)
                    )
                }
            }
        }
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    darkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    // Definisi navigasi antar halaman
    NavHost(navController, startDestination = "form", modifier = modifier) {
        // Halaman Form Profil
        composable("form") { ProfileFormScreen(navController) }

        // Halaman Ringkasan Profil, ambil data dari route
        composable("summary/{nama}/{kelas}/{hobi}") { backStackEntry ->
            val nama = backStackEntry.arguments?.getString("nama") ?: ""
            val kelas = backStackEntry.arguments?.getString("kelas") ?: ""
            val hobi = backStackEntry.arguments?.getString("hobi") ?: ""
            ProfileSummaryScreen(navController, nama, kelas, hobi, darkTheme, onThemeChange)
        }

        // Halaman Pengaturan
        composable("saved") { SavedSettingsScreen(navController) }
    }
}

@Composable
fun BottomNavBar(navController: NavHostController) {
    // Daftar item untuk bottom navigation
    val items = listOf(
        BottomNavItem("Form", "form", Icons.Filled.Home),
        BottomNavItem("Ringkasan", "summary", Icons.Filled.Person),
        BottomNavItem("Pengaturan", "saved", Icons.Filled.Settings)
    )

    // Dapatkan route saat ini untuk menandai item yang aktif
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    // Komponen NavigationBar
    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.label) }, // Ikon item
                label = { Text(item.label) }, // Label item
                selected = currentRoute == item.route, // Tandai item yang aktif
                onClick = { navController.navigate(item.route) } // Navigasi saat diklik
            )
        }
    }
}

// Model data untuk item Bottom Navigation
data class BottomNavItem(
    val label: String,
    val route: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
)

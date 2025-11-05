package id.antasari.uts_mp_230104040056.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Dark Color Scheme - lebih elegan dengan hijau tosca pastel gelap
private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF4DB6AC), // Hijau Tosca pastel yang lebih gelap
    secondary = Color(0xFF80CBC4), // Hijau Tosca pastel cerah
    tertiary = Color(0xFFB2DFDB)  // Hijau Tosca pastel sangat lembut
)

// Light Color Scheme - hijau tosca pastel lembut dan elegan
private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF4DB6AC), // Hijau Tosca pastel gelap yang elegan
    secondary = Color(0xFF80CBC4), // Hijau Tosca pastel cerah
    tertiary = Color(0xFFB2DFDB)  // Hijau Tosca pastel lembut
)

@Composable
fun UTS_MP_230104040056Theme(
    darkTheme: Boolean = false, // ← ini bisa diubah lewat switch
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

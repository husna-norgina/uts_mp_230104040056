# UTS Pemrograman Mobile – Husna Norgina_230104040056

---

## Paket A: Profile & Preference App

Aplikasi Android **Jetpack Compose** dengan 3 screen:  

1. **Form Profil**  
   - Input: Nama Lengkap, Kelas, Hobi  
   - Tombol: "Simpan & Lanjut"  
   - Logic: Data dikirim ke screen berikutnya  

---

2. **Ringkasan Profil**  
   - Menampilkan data dari Form Profil  
   - Toggle / Switch untuk **Aktifkan Mode Gelap (Ya/Tidak)**  
   - Tombol: "Simpan ke Perangkat"  

---

3. **Pengaturan Tersimpan**  
   - Menampilkan kembali: Nama, Kelas, Hobi, dan status Mode Gelap  
   - Mengambil data dari **SharedPreferences**  
   - Jika belum ada data: menampilkan pesan “Belum ada data, silakan isi profil dulu”  
   - Tombol: "Kembali ke Form"  

---

## Fitur Teknis
- Navigasi menggunakan `NavHost` / `NavController`  
- Penyimpanan lokal menggunakan **SharedPreferences**  
- Minimal 1 state menggunakan `remember { mutableStateOf(...) }`  
- Mendukung **Dark Mode**  
- Struktur file dan penamaan sesuai ketentuan praktikum  

---

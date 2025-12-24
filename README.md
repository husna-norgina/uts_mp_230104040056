# 📱 UTS — Profile & Preference App (Jetpack Compose)

Ujian Tengah Semester (UTS) ini membahas **pengembangan aplikasi Android berbasis Jetpack Compose** dengan fokus pada **manajemen state**, **navigasi multi-screen**, serta **penyimpanan data lokal sederhana** menggunakan **SharedPreferences**. Aplikasi yang dikembangkan adalah **Profile & Preference App**, yang memungkinkan pengguna mengisi data profil, menampilkan ringkasan data, mengatur preferensi **Dark Mode**, serta menampilkan kembali data yang tersimpan secara persisten.
Aplikasi dirancang menggunakan pendekatan **Material Design 3 (MD3)** untuk memastikan tampilan yang modern, konsisten, dan nyaman digunakan.

**Topik:** Jetpack Compose, State Management, Navigation, SharedPreferences, Dark Mode, Material Design 3

---

## 🧑‍🎓 Informasi Mahasiswa

| Informasi      | Data                                                 |
| -------------- |------------------------------------------------------|
| Mata Kuliah    | Pemrograman Mobile                                   |
| Dosen Pengampu | Muhayat, M.IT                                        |
| Proyek         | Ujian Tengah Semester (UTS)                          |
| Nama Mahasiswa | Husna Norgina                                        |
| NIM            | 230104040056                                         |
| Kelas          | TI23B                                                |
| Repo GitHub    | https://github.com/husna-norgina/uts_mp_230104040056 |
| Tanggal UTS    | 05-11-2025                                           |

---

## 🎯 Tujuan UTS

1. Memahami perbedaan **UI statis** dan **UI berbasis state** pada Jetpack Compose.
2. Menerapkan **state management** untuk mengelola data dan tampilan UI secara dinamis.
3. Mengimplementasikan **navigasi multi-screen** pada aplikasi Compose.
4. Mengirim data antar screen menggunakan parameter navigasi.
5. Menyimpan data profil dan preferensi menggunakan **SharedPreferences**.
6. Menerapkan **Dark Mode** sebagai preferensi pengguna.
7. Menampilkan kembali data tersimpan secara persisten.
8. Menangani kondisi **data belum tersedia** dengan pesan yang informatif.
9. Mendesain UI menggunakan **Material Design 3 (MD3)**.
10. Menghasilkan aplikasi yang stabil, rapi, dan mudah digunakan.

---

## 🛠 Tools & Environment

* Android Studio (Narwhal | 2025.1.1)
* Android SDK (compileSdk 35, targetSdk 35, minSdk 24)
* Bahasa pemrograman Kotlin
* Jetpack Compose & Material 3
* SharedPreferences (key–value storage)
* Android Emulator / Real Device
* Git & GitHub

---

## 🧱 Struktur Aplikasi

Aplikasi dikembangkan menggunakan **Jetpack Compose**, dengan struktur utama sebagai berikut:

* **FormProfileScreen.kt** — Screen 1: Form input profil pengguna
* **SummaryProfileScreen.kt** — Screen 2: Ringkasan profil & pengaturan Dark Mode
* **SavedSettingScreen.kt** — Screen 3: Data profil & preferensi tersimpan
* **NavigationGraph.kt** — Pengelolaan navigasi antar screen
* **PreferenceManager.kt** — Pengelolaan SharedPreferences
* **Theme (MD3)** — Light Mode & Dark Mode
* **Bottom Navigation** — Navigasi Form, Ringkasan, dan Pengaturan

---

## 🧩 Implementasi UTS

### 🔹 Screen 1 — Form Profil

Pengguna mengisi data **Nama Lengkap, Kelas, dan Hobi**.
Setelah tombol **Simpan & Lanjut** ditekan, data dikirim ke Screen 2.

### 🔹 Screen 2 — Ringkasan Profil

Menampilkan data profil dari Screen 1 dan menyediakan **toggle Dark Mode**.
Data dapat disimpan ke penyimpanan lokal melalui tombol **Simpan ke Perangkat**.

### 🔹 Screen 3 — Pengaturan Tersimpan

Menampilkan kembali data profil dan status Dark Mode yang diambil dari **SharedPreferences**.
Jika data belum ada, aplikasi menampilkan pesan **“Belum ada data, silakan isi profil dulu”**.

---

## 📸 Screenshot UTS

Berikut merupakan hasil implementasi aplikasi **Profile & Preference App** pada **UTS Pemrograman Mobile**:

**Gambar 1.** Screen 1 – Form Profil (Mode Terang)
![Form Profil Mode Terang](evidence/1.%20Screen%201_Form%20Profil_Mode%20Terang.jpg)

**Gambar 2.** Screen 2 – Ringkasan Profil (Mode Terang)
![Ringkasan Profil Mode Terang](evidence/2.%20Screen%202_Ringkasan%20Profil_Mode%20Terang.jpg)

**Gambar 3.** Screen 3 – Pengaturan Tersimpan (Mode Terang)
![Pengaturan Tersimpan Mode Terang](evidence/3.%20Screen%203_Pengaturan%20Tersimpan_Mode%20Terang.jpg)

**Gambar 4.** Screen 3 – Pengaturan Tersimpan (Belum Ada Data)
![Belum Ada Data](evidence/4.%20Screen%203_Pengaturan%20Tersimpan_Belum%20ada%20data.jpg)

**Gambar 5.** Screen 1 – Form Profil (Mode Gelap)
![Form Profil Mode Gelap](evidence/5.%20Screen%201_Form%20Profil_Mode%20Gelap.jpg)

**Gambar 6.** Screen 2 – Ringkasan Profil (Mode Gelap)
![Ringkasan Profil Mode Gelap](evidence/6.%20Screen%202_Ringkasan%20Profil_Mode%20Gelap.jpg)

**Gambar 7.** Screen 3 – Pengaturan Tersimpan (Mode Gelap)
![Pengaturan Tersimpan Mode Gelap](evidence/7.%20Screen%203_Pengaturan%20Tersimpan_Mode%20Gelap.jpg)

---

## 📄 Laporan UTS

[UTS_MP_Husna Norgina_230104040056.pdf](evidence/UTS_MP_Husna%20Norgina_230104040056.pdf)

> Semua screenshot dan laporan praktikum disimpan pada folder:  
> 📂 `./evidence/`

---

## 📊 Analisis UTS

* State pada Jetpack Compose dikelola dengan baik sehingga UI bersifat dinamis.
* Navigasi antar screen berjalan lancar.
* Data profil dan preferensi tersimpan secara persisten.
* Dark Mode diterapkan dan diingat oleh aplikasi.
* Kondisi data kosong ditangani dengan pesan yang jelas.
* Tampilan konsisten dengan Material Design 3.
* Aplikasi stabil pada emulator maupun perangkat fisik.

---

## ✅ Kesimpulan

Berdasarkan hasil **UTS Pemrograman Mobile**, aplikasi **Profile & Preference App** berhasil mengimplementasikan konsep **state management**, **navigasi Compose**, serta **penyimpanan data lokal** secara efektif. Penggunaan **Jetpack Compose dan Material Design 3** menghasilkan aplikasi yang modern, responsif, dan mampu menjaga **pengalaman pengguna yang konsisten** melalui penyimpanan preferensi dan data profil.

---

## 📌 Catatan

* UTS dikerjakan sesuai instruksi soal.
* Seluruh fitur utama berhasil diimplementasikan.
* Dokumentasi dilakukan secara sistematis melalui screenshot.
* Proyek ini dibuat untuk keperluan evaluasi akademik.

---

📝 *Disusun oleh Husna Norgina (230104040056) — UTS Pemrograman Mobile*

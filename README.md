# 🎬 MovieBox – QA Automation Testing

## 📌 Project Overview
MovieBox QA Automation Testing merupakan project automation testing untuk aplikasi web MovieBox, sebuah aplikasi pencarian film yang terintegrasi dengan OMDb API.  
Automation testing dibuat berdasarkan test scenario dan test case yang telah disusun untuk memastikan seluruh fitur utama aplikasi berjalan sesuai kebutuhan sistem.

---

## 🔍 Application Under Test (AUT)
- **Nama Aplikasi:** MovieBox
- **Platform:** Web Application
- **Backend:** Laravel
- **API:** OMDb API

🔗 **Source Code Aplikasi (Laravel):**  
👉 [https://github.com/username/moviebox-laravel  ](https://github.com/myogaazwar/Movie-Box-Laravel.git)

📁 **Test Scenario & Test Case:**  
👉 Google Drive: https://drive.google.com/drive/folders/1CGCHEOr_yr-rWG-j68L_jsbC-zRRnYs_?usp=sharing

---

## 🧪 Scope of Testing

### 🔐 Authentication
- Login dengan data valid
- Validasi login gagal (input kosong / credential salah)
- Akses halaman tanpa login
- Logout dan redirect ke halaman login

### 🎥 Movies
- Menampilkan daftar film default
- Pencarian film berdasarkan judul
- Validasi pencarian kosong
- Menampilkan detail film

### ⭐ Favorite Movies
- Menambahkan film ke daftar favorit
- Menghapus film dari daftar favorit
- Menampilkan pesan saat daftar favorit kosong

---

## 🧠 Testing Approach
- Manual Testing menggunakan **Black Box Testing**
- Automation Testing menggunakan **Selenium WebDriver**
- Test case dibagi menjadi:
  - Positive Test Case
  - Negative Test Case

---

## 🛠 Tools & Technologies
- Java
- Selenium WebDriver
- TestNG
- Maven
- WebDriverWait (Explicit Wait)
- Git & GitHub

---
### Prerequisites
- Java JDK
- Maven
- Chrome / Edge Browser
- WebDriver (ChromeDriver / EdgeDriver)
- Aplikasi MovieBox sudah berjalan di local environment

### Run Test
```bash
mvn clean test

# 📂 GitHub Repo Viewer

A high‑performance, modular Android application for exploring GitHub repositories, showcasing **Kotlin**, **Jetpack Compose**, and **Clean Architecture** in a production‑ready setup.

---

## 🚀 Tech Highlights

| Category                 | Technology/Library                               |
| ------------------------ | ------------------------------------------------ |
| **Language**             | [Kotlin](https://kotlinlang.org/)                |
| **UI Toolkit**           | [Jetpack Compose (Material 3)](https://developer.android.com/jetpack/androidx/releases/compose-material3)|
| **Architecture**         | Multi‑Module MVVM Clean                          |
| **Dependency Injection** | [Dagger Hilt](https://dagger.dev/hilt/)          |
| **Networking**           | [etrofit](https://square.github.io/retrofit/)    |
| **Local Caching**        | [Room](https://developer.android.com/training/data-storage/room?hl=ar)|
| **Pagination**           | [Paging 3](https://developer.android.com/topic/libraries/architecture/paging/v3-overview) |
| **State Management**     | [Coroutines + StateFlow](http://developer.android.com/kotlin/coroutines)|
| **Image Loading**        | [Coil](https://github.com/coil-kt/coil)          |
| **Animation**            | [Lottie](https://github.com/airbnb/lottie-android) |

---

## 🧱 Architecture Overview

The app follows **Clean Architecture** principles with well‑defined layers:

* **Presentation:** Jetpack Compose UI + ViewModel using StateFlow
* **Domain:** Business logic, use cases
* **Data:** Repository implementations, DTOs, mappers
* **App:** Shared modules for UI, network, and database utilities

**Data Flow:**

```
UI → ViewModel → UseCase → Repository → Remote (Retrofit) / Local (Room)
```

Benefits:

* ✅ Clear separation of concerns
* 🧪 High testability
* 🔧 Easy scalability and maintainability

---

## 🎯 Features

* 📂 View public repositories from GitHub
* 📜 Access repository details
* 🐞 Browse issues for a repository
* 💾 Offline caching with Room and Paging 3
* 🔄 Automatic background syncing via RemoteMediator
* 📱 Single‑activity architecture with Compose Navigation
* 🎨 Smooth animations with Lottie
* 🖼 Efficient image loading with Coil

---

## 🌐 API Endpoints

**Base URL:** `https://api.github.com`

* **List Repositories:** `GET /repositories`
* **Repository Details:** `GET /repos/{owner}/{repo}`
* **Repository Issues:** `GET /repos/{owner}/{repo}/issues`

---

## 📸 Screenshots

| HOME          | RDETAILS       | ISSUES       |
| --------------------------- | -------------------------- | ----------------------- |
| ![HOME](https://github.com/JonathnEhab/GitHubRepositoryClnArt/blob/master/home.jpg) | ![DETAILS](https://github.com/JonathnEhab/GitHubRepositoryClnArt/blob/master/Details.jpg) | ![ISSUES](https://github.com/JonathnEhab/GitHubRepositoryClnArt/blob/master/issues.jpg) |




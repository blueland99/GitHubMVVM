package com.blueland99.github_mvvm.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {
    // 필요 시 애플리케이션 초기화 로직 추가
}
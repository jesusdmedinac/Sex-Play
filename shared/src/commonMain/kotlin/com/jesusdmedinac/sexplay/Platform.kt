package com.jesusdmedinac.sexplay

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
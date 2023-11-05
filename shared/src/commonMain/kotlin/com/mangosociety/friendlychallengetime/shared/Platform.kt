package com.mangosociety.friendlychallengetime.shared

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
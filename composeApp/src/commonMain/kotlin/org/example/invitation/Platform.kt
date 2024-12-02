package org.example.invitation

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
package ru.wall

data class Photo  (
    val id: Long,
    val albumId: Long,
    val ownerId: Long,
    val userId: Long
)
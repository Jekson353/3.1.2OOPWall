package ru.wall

data class Video (
    val id: Long,
    val albumId: Long,
    val ownerId: Long,
    val userId: Long
)
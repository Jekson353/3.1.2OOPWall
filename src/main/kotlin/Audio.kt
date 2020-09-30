package ru.wall

data class Audio (
    val id: Long,
    val albumId: Long,
    val ownerId: Long,
    val userId: Long
)
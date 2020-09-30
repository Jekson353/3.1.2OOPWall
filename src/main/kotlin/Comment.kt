package ru.wall

data class Comment (
    val id: Int = WallService.getNumberComment(),
    val postId: Int,
    val fromId: Int,
    val date: Long,
    val text: String = "",
    val replyToUser: Int,
    val replyToComment: Int,
    val attachment: Attachment?,
)
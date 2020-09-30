package ru.wall

sealed class Attachment {
    abstract val type: AttachmentType
}
data class VideoAttachment(override val type: AttachmentType, val video: Video) : Attachment()
data class AudioAttachment(override val type: AttachmentType, val audio: Audio) : Attachment()
data class PhotoAttachment(override val type: AttachmentType, val photo: Photo) : Attachment()
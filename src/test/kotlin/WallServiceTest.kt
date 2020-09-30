package ru.wall

import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun add() {
        val service = WallService
        val attachment: Attachment = AudioAttachment(AttachmentType.AUDIO, Audio(id = 1, ownerId = 10, albumId = 15, userId = 100))
        val post = Post(
            ownerId = 15,
            fromId = 25,
            createdBy = 1,
            date = 0,
            text = "Новый пост 1",
            replyPostId = 10,
            comments = "",
            copyright = "",
            likes = 0,
            views = 0,
            attachments = attachment,
            postType = "",
            signerId = 0,
            replyOwnerId = null,
            geo = null,
            postSource = null,
            reposts = null,
        )
        val result = service.add(post)
        assertEquals(result, post)
    }


    @Test
    fun update() {
        val service = WallService
        val attachment: Attachment = AudioAttachment(AttachmentType.AUDIO, Audio(id = 1, ownerId = 10, albumId = 15, userId = 100))
        val post = Post(
            ownerId = 15,
            fromId = 25,
            createdBy = 1,
            date = 0,
            text = "Новый пост 1",
            replyPostId = 10,
            comments = "",
            copyright = "",
            attachments = attachment,
            likes = 0,
            views = 0,
            postType = "",
            signerId = 0,
            replyOwnerId = null,
            geo = null,
            postSource = null,
            reposts = null,
        )
        service.add(Post(ownerId = 10,createdBy = 0, date = 0, fromId = 10, attachments = null, replyOwnerId = null, geo = null, postSource = null, reposts = null))
        val result = service.update(post)
        assertTrue(result)
    }

    @Test(expected = Exception::class)
    fun createCommentError() {
        val service = WallService
        val comment = Comment(
            postId = 10,
            fromId = 5,
            date = 0,
            text = "Комментарий поста",
            replyToUser = 1,
            replyToComment = 0,
            attachment = null
        )

        val result = service.createComment(comment, 0)
        assertThat(result, throw Exception("PostNotFoundException"))
    }


    @Test
    fun createCommentOk() {
        val service = WallService
        val post = Post(
            ownerId = 15,
            fromId = 25,
            createdBy = 1,
            date = 0,
            text = "Новый пост 1",
            replyPostId = 10,
            comments = "",
            copyright = "",
            likes = 0,
            views = 0,
            attachments = null,
            postType = "",
            signerId = 0,
            replyOwnerId = null,
            geo = null,
            postSource = null,
            reposts = null,
        )
        service.add(post)
        val comment = Comment(
            postId = 0,
            fromId = 5,
            date = 0,
            text = "Комментарий поста",
            replyToUser = 1,
            replyToComment = 0,
            attachment = null
        )

        val result =service.createComment(comment, 0)
        assertEquals(result, comment)
    }

    @Test
    fun getNumberComment() {
        val servic = WallService
        val result = servic.getNumberComment()
        assertEquals(result, 0)
    }
    
    @Test
    fun getPost() {
        val service = WallService
        val result = service.getPost(id = 20)
        assertEquals(result, "Пост с таким ID не найден.")
    }

}
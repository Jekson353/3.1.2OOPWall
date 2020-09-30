package ru.wall

object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()

    fun getNumberPost(): Int {
        return posts.lastIndex + 1
    }

    fun getNumberComment(): Int {
        return comments.lastIndex + 1
    }

    fun createComment(comment: Comment, id: Int):Comment {
        if (isPost(id)){
            comments+=comment
            return comments.last()
        }else{
            throw Exception("PostNotFoundException")
        }
    }

    fun add(post: Post): Post {
        if (posts.isNotEmpty()) {
            for (i: Int in 0..posts.size) {
                val searchPost = posts[i]
                if (post.id == searchPost.id) {
                    break
                } else {
                    posts += post
                    return posts.last()
                }
            }
            return posts.last()
        } else {
            posts += post
            return posts.last()
        }
    }

    fun update(post: Post): Boolean {
        if (posts.isNotEmpty()) {
            for (i: Int in 0..posts.size) {
                val searchPost = posts[i]
                if (post.id == searchPost.id) {
                    val updatedPost = post.copy(
                        id = searchPost.id,
                        date = searchPost.date,
                    )
                    posts[i] = updatedPost
                    return true
                }
            }
            return false
        }
        return false
    }

    fun isPost(id: Int): Boolean {
        for (post in posts) {
            if (post.id == id) {
                return true
            }
        }
        return false
    }

    fun getPost(id: Int): String {
        for ((index, post) in posts.withIndex()) {
            if (post.id == id) {
                return posts[index].toString()
            }
        }
        return "Пост с таким ID не найден."
    }
}
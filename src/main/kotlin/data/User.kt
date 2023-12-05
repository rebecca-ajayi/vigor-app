package data

import EnumClasses.HavenCategory

data class User(
    val id: String,
    val username: String,
    val email: String,
    val password: String,
    val name: String,
    val profileImage: String?,
    val bio: String?,
    val demographicInfo: Map<String, Any>?
)

data class Haven(
    val id: String,
    val name: String,
    val description: String,
    val category: HavenCategory,
    val creator: String, // ref User.id
    val admins: List<String> // ref User.id
)

data class Post(
    val id: String,
    val parentHaven: String, // ref Haven.id
    val author: String, // ref User.id
    val title: String,
    val textContent: String,
    val imageUrl: String?,
    val videoUrl: String?,
    val upvotes: Int,
    val downvotes: Int,
    val commentCount: Int
)

data class Comment(
    val id: String,
    val parentPost: String, // ref Post.id
    val author: String, // ref User.id
    val content: String,
    val upvotes: Int,
    val downvotes: Int
)

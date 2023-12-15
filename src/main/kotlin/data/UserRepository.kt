package data

import org.h2.engine.User

interface UserRepository {
    fun getUserById(id: String): User?
    suspend fun createUser(user: User): User
}

object InMemoryUserRepo: UserRepository {

    private val users = mutableListOf<User>()

    override fun getUserById(id: String): User? {
        return users.find { it.id.toString() == id }
    }

    override suspend fun createUser(user: User): User {
        users.add(user)
        return user
    }

}
package com.biblia.app.tree.service

import com.biblia.app.tree.entity.User
import com.biblia.app.tree.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
data class UserService(

  @Autowired
  private val userRepository: UserRepository
) {
  fun createUser(user: User): User {
    return userRepository.save(user)
  }

  fun findAllUser(): List<User> {
    return userRepository.findAll()
  }

  fun findUserById(id: Long): Optional<User> {
    return userRepository.findById(id)
  }

  fun deleteUser(id: Long): String {
    userRepository.deleteById(id)
    return "deleted successfully"
  }
}
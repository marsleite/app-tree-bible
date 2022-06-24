package com.biblia.app.tree.service

import com.biblia.app.tree.repository.UserRepository
import com.biblia.app.tree.type.UserRole
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.autoconfigure.security.SecurityProperties.User
import java.util.*
import com.biblia.app.tree.entity.User as Users

@ExtendWith(MockKExtension::class)
internal class UserServiceTest {
  @InjectMockKs
  lateinit var target: UserService

  @MockK
  lateinit var repository: UserRepository

  @Test
  fun `create user successfully`() {
    // given
    val user1 = Users(1L, "Marcelo", "Leite", "email@email.com", "123456", UserRole.NORMAL)

    every {
      repository.save(user1)
    } returns user1

    assertEquals(user1, target.createUser(user1))
  }

  @Test
  fun `find all user successfully`() {
    // given
    val user1 = Users(1L, "Marcelo", "Leite", "email@email.com", "123456", UserRole.NORMAL)
    val user2 = Users(2L, "Mauricio", "Leite", "email@email.com", "123456", UserRole.NORMAL)

    every {
      repository.findAll()
    } returns listOf(user1, user2)

    val result = target.findAllUser()

    assertThat(result).containsExactlyInAnyOrder(user1, user2)
  }

  @Test
  fun `find user by id successfully`() {
    val user1 = Users(1L, "Marcelo", "Leite", "email@email.com", "123456", UserRole.NORMAL)

    every {
      repository.findById(1L)
    } returns Optional.of(user1)

    assertEquals(Optional.of(user1), target.findUserById(1L))
  }

//  @Test
//  fun `delete user by id successfully`() {
//    val user1 = Users(1L, "Marcelo", "Leite", "email@email.com", "123456", UserRole.NORMAL)
//
//    every {
//      repository.findById(1L)
//    } returns Optional.of(user1)
//
//    every {
//      repository.delete(user1)
//    } returns Unit
//
//    target.deleteUser(1L)
//
//    assertEquals(Optional.of(user1), target.findUserById(1L))
//  }
}

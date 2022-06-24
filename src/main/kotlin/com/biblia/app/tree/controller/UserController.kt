package com.biblia.app.tree.controller

import com.biblia.app.tree.entity.User
import com.biblia.app.tree.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController
@RequestMapping("/api/v1/users")
class UserController(
  @Autowired
  private val service: UserService
) {

  @PostMapping("/register")
  fun createUser(@RequestBody user: User): ResponseEntity<User> {
    val result = service.createUser(user)
    return ResponseEntity(result, HttpStatus.CREATED)
  }

  @GetMapping
  fun findAllUsers(): ResponseEntity<List<User>> {
    val result = service.findAllUser()
    return ResponseEntity(result, HttpStatus.OK)
  }

  @GetMapping("/{id}")
  fun findUserById(@PathVariable id: String): ResponseEntity<Optional<User>> {
    val result = service.findUserById(id.toLong())
    return ResponseEntity(result, HttpStatus.OK)
  }

  @DeleteMapping("/delete/{id}")
  fun deleteUser(@PathVariable id: String): ResponseEntity<String> {
    val result = service.deleteUser(id.toLong())
    return ResponseEntity(result, HttpStatus.OK)
  }
}
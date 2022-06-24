package com.biblia.app.tree.repository

import com.biblia.app.tree.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
}
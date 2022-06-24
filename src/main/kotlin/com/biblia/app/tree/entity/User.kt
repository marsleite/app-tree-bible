package com.biblia.app.tree.entity

import com.biblia.app.tree.type.UserRole
import javax.persistence.*

@Entity
@Table(name = "tb_users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    val id: Long,

    @Column(name = "first_name")
    val firstName: String,

    @Column(name = "last_name")
    val lastName: String,

    @Column(name = "email")
    val email: String,

    @Column(name = "password")
    val password: String,

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    val role: UserRole

)
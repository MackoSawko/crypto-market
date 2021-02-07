package com.sawczuk.maciej.cryptomarket.repository

import com.sawczuk.maciej.cryptomarket.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long> {
}

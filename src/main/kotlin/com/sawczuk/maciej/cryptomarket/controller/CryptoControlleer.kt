package com.sawczuk.maciej.cryptomarket.controller

import com.sawczuk.maciej.cryptomarket.exceptions.UserNotFoundException
import com.sawczuk.maciej.cryptomarket.model.User
import com.sawczuk.maciej.cryptomarket.model.Wallet
import com.sawczuk.maciej.cryptomarket.repository.UserRepository
import com.sawczuk.maciej.cryptomarket.repository.WalletRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class CryptoControlleer {

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var walletRepository: WalletRepository

    @GetMapping("/users")
    fun getUsers(): List<User> {
        return userRepository.findAll()
    }

    @GetMapping("/user/{id}")
    fun getUserById(@PathVariable id: Long): User {
        return userRepository
                .findById(id)
                .orElseThrow { throw UserNotFoundException("Niiii ma") }
    }

    @PostMapping("/user")
    fun addUser(@RequestParam("firstName") firstName: String,
                       @RequestParam("lastName") lastName: String): User {

        val wallet = Wallet(btc = 5.0, usd = 1250.0)
        walletRepository.save(wallet)

        val user = User(firstName = firstName, lastName = lastName, wallet = wallet)
        userRepository.save(user)

        return user
    }
}

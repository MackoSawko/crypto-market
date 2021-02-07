package com.sawczuk.maciej.cryptomarket.repository

import com.sawczuk.maciej.cryptomarket.model.Wallet
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WalletRepository: JpaRepository<Wallet, Long> {
}

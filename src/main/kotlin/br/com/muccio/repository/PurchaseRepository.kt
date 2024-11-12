package br.com.muccio.repository

import br.com.muccio.model.PurchaseModel
import org.springframework.data.jpa.repository.JpaRepository

interface PurchaseRepository: JpaRepository<PurchaseModel, Int> {

    fun findByCustomerId(id: Int): List<PurchaseModel>
}

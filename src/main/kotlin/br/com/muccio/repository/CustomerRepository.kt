package br.com.muccio.repository

import br.com.muccio.model.CustomerModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<CustomerModel, Int> {


    fun findByNameContaining(name: String, pageable: Pageable): Page<CustomerModel>

    fun existsByEmail(email: String): Boolean


}
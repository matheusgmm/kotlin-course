package br.com.muccio.repository

import br.com.muccio.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<CustomerModel, Int> {


    fun findByNomeContaining(name: String): List<CustomerModel>


}
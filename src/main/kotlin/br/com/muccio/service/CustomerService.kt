package br.com.muccio.service

import br.com.muccio.model.CustomerModel
import br.com.muccio.repository.CustomerRepository
import org.springframework.stereotype.Service


@Service
class CustomerService(
    val customerRepository: CustomerRepository
) {


    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customerRepository.findByNomeContaining(it)
        }

        return customerRepository.findAll().toList()

    }

    fun createCustomer(customer: CustomerModel) {
        customerRepository.save(customer)
    }

    fun getCustomer(id: Int): CustomerModel {
        return customerRepository.findById(id).orElseThrow { NoSuchElementException("Customer with id: $id not found!") }
    }

    fun updateCustomer(customer: CustomerModel) {
        val findCustomer = customerRepository.findById(customer.id!!).orElseThrow { NoSuchElementException("Customer with id: ${customer.id} not found!") }
        findCustomer.let {
            it.nome = customer.nome
            it.email = customer.email
        }
        customerRepository.save(customer)
    }

    fun deleteCustomer(id: Int) {
        if (!customerRepository.existsById(id)) {
            throw Exception()
        } else {
            customerRepository.deleteById(id)
        }
    }

}
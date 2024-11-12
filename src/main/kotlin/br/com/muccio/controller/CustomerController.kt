package br.com.muccio.controller

import br.com.muccio.controller.request.PostCustomerRequest
import br.com.muccio.controller.request.PutCustomerRequest
import br.com.muccio.controller.response.CustomerResponse
import br.com.muccio.controller.response.PurchaseResponse
import br.com.muccio.extension.toCustomerModel
import br.com.muccio.extension.toResponse
import br.com.muccio.service.CustomerService
import br.com.muccio.service.PurchaseService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("api/v1/customer")
class CustomerController(
    var customerSevice: CustomerService,
    var purchaseService: PurchaseService
) {

    @GetMapping
    fun getAll(
        @RequestParam name: String?,
        @PageableDefault(page = 0, size = 10) pageable: Pageable
    ): Page<CustomerResponse> {
        return customerSevice.getAll(name, pageable).map { it.toResponse() }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody @Valid customer: PostCustomerRequest) {
        return customerSevice.createCustomer(customer.toCustomerModel())
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: Int): CustomerResponse {
        return customerSevice.findById(id).toResponse()
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@PathVariable id: Int, @RequestBody @Valid customer: PutCustomerRequest) {
        val customerSaved = customerSevice.findById(id)
        return customerSevice.updateCustomer(customer.toCustomerModel(customerSaved))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id: Int) {
        customerSevice.deleteCustomer(id)
    }

    @GetMapping("/purchase/{id}")
    fun purchase(@PathVariable id: Int): ResponseEntity<List<PurchaseResponse>> {
        val purchase = purchaseService.findPurchaseByCustomerId(id)
        return ResponseEntity.ok(purchase)
    }

}
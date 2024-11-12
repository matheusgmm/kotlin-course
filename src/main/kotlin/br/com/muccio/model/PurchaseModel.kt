package br.com.muccio.model

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime


@Entity(name = "purchase")
data class PurchaseModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer: CustomerModel,

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "purchase_book",
        joinColumns = [JoinColumn(name = "purchase_id")],
        inverseJoinColumns = [JoinColumn(name = "book_id")]
    )
    var books: MutableList<BookModel>,

    @Column
    var nfe: String? = null,

    @Column
    var price: BigDecimal,

    @Column(name = "created_at")
    var createdAt: LocalDateTime = LocalDateTime.now()

)
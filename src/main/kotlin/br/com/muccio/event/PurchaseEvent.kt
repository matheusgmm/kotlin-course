package br.com.muccio.event

import br.com.muccio.model.PurchaseModel
import org.springframework.context.ApplicationEvent

class PurchaseEvent (
    source: Any,
    val purchaseModel: PurchaseModel

): ApplicationEvent(source)
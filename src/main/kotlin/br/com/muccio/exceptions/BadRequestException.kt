package br.com.muccio.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
class BadRequestException(override val message: String, val errorCode: String): Exception() { }
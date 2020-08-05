package by.chekun.exception

import org.springframework.validation.FieldError


class IllegalRequestException : RuntimeException {
    val errors: List<FieldError>

    constructor(errors: List<FieldError>) : super() {
        this.errors = errors
    }

    constructor(message: String?, errors: List<FieldError>) : super(message) {
        this.errors = errors
    }

}
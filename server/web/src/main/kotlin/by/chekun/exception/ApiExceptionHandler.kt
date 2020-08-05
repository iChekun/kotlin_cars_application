package by.chekun.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*
import java.util.function.Consumer


@ControllerAdvice
class ApiExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFound(e: ResourceNotFoundException): ResponseEntity<ErrorMessage>? {
        /*
         * Exception occurs when passed id is null. Status 404.
         */
        val message = if (Objects.isNull(e.message)) "" else e.message!!
        return ResponseEntity(
            ErrorMessage(message, HttpStatus.NOT_FOUND.value()),
            HttpStatus.NOT_FOUND
        )
    }

    @ExceptionHandler(IllegalRequestException::class)
    fun handleValidation(e: IllegalRequestException): ResponseEntity<List<ErrorMessage?>>? {
        /*
         * Validation exceptions handling. Status code 400.
         */
        val errors: MutableList<ErrorMessage?> = ArrayList()
        e.errors.forEach(Consumer { er: FieldError ->
            errors.add(
                ErrorMessage(
                    String.format(
                        "Incorrect value for field %s : '%s'. %s.", er.field,
                        er.rejectedValue, er.defaultMessage
                    ), HttpStatus.BAD_REQUEST.value()
                )
            )
        })

        return ResponseEntity(errors, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(ResourceAttributeConflictException::class)
    fun handleAttributeConflict(e: ResourceAttributeConflictException): ResponseEntity<ErrorMessage>? {
        /*
         * Exception occurs when some conflict happens (like duplicate title or any unique field). Status 409.
         */
        val message = e.message!!

        return ResponseEntity(
            ErrorMessage(message, HttpStatus.CONFLICT.value()),
            HttpStatus.CONFLICT
        )
    }


    @ExceptionHandler(Throwable::class)
    fun handleOthersException(e: Throwable): ResponseEntity<ErrorMessage>? {
        /* Handles all other exceptions. Status code 500. */
        e.printStackTrace()


        println(e)
        println(e.message)
        return ResponseEntity(
            ErrorMessage("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR.value()),
            HttpStatus.INTERNAL_SERVER_ERROR
        )
    }
}
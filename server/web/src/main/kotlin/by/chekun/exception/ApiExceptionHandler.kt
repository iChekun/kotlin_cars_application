package by.chekun.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.DataBinder
import org.springframework.validation.FieldError
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.InitBinder
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*
import java.util.function.Consumer
import javax.validation.ConstraintViolationException


@ControllerAdvice
class ApiExceptionHandler : ResponseEntityExceptionHandler() {

    @InitBinder
    private fun activateDirectFieldAccess(dataBinder: DataBinder) {
        dataBinder.initDirectFieldAccess()
    }

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

    @ExceptionHandler(ConstraintViolationException::class)
    fun handleConstraintViolationException(e: ConstraintViolationException): ResponseEntity<List<ErrorMessage>>? {

        println(e)

        val errors = ArrayList<ErrorMessage>()
        e.constraintViolations.forEach { er ->
            errors.add(ErrorMessage(er.messageTemplate, HttpStatus.BAD_REQUEST.value()))
        }
        return ResponseEntity(errors, HttpStatus.BAD_REQUEST)
    }


    @ExceptionHandler(
        UnsatisfiedServletRequestParameterException::class,
        IllegalArgumentException::class,
        MethodArgumentTypeMismatchException::class
    )
    fun handleJsonMappingException(e: Exception): ResponseEntity<ErrorMessage>? {
        /*
         * Exception occurs when passed id is null. Status 400.
         */
        return ResponseEntity(
            ErrorMessage("Request parameters are not valid!", HttpStatus.BAD_REQUEST.value()),
            HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler(IllegalRequestException::class)
    fun handleValidation(e: IllegalRequestException): ResponseEntity<List<ErrorMessage?>>? {
        /*
         * Validation exceptions handling. Status code 400.
         */

        println(e)

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
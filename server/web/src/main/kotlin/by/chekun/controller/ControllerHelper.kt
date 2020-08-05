package by.chekun.controller

import by.chekun.exception.IllegalRequestException
import org.springframework.validation.BindingResult


internal object ControllerHelper {

    fun checkBindingResultAndThrowExceptionIfInvalid(result: BindingResult) {
        if (result.hasErrors()) {
            throw IllegalRequestException(result.fieldErrors)
        }
    }

}
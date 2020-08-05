package by.chekun.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.validation.constraints.NotNull


@JsonIgnoreProperties(ignoreUnknown = true)
class Paging(
    @field:NotNull(message = "Size can`t be null!") var size: Int,
    @field:NotNull(message = "Page can`t be null!") var page: Int
) {

    fun defineStartPosition(): Int {
        return (page - 1) * size
    }

    override fun toString(): String {
        return "Paging{" +
                "page=" + page +
                ", size=" + size +
                '}'
    }

}
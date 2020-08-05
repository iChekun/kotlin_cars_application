package by.chekun.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class CarSearchCriteria(

    val model: String?,

    val releaseYear: Int?,

    val minPrice: Double?,

    val maxPrice: Double?,

    val brandTitle: String?,

    val sortBy: String,

    val sortType: String

)
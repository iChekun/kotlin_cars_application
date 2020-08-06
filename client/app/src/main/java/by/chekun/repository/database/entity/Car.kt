package by.chekun.repository.database.entity

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "cars")
data class Car(

        @PrimaryKey(autoGenerate = true)
        @SerializedName("id")
        val id: Long,

        @SerializedName("model")
        val model: String,

        @SerializedName("generation")
        val generation: String,

        @SerializedName("mileage")
        var mileage: Double,

        @SerializedName("bodyType")
        val bodyType: String,

        @SerializedName("transmissionType")
        val transmissionType: String,

        @SerializedName("fuelType")
        val fuelType: String,

        @SerializedName("wheelDriveType")
        val wheelDriveType: String,

        @SerializedName("engineCapacity")
        val engineCapacity: Double,


        @SerializedName("releaseYear")
        val releaseYear: Int,

        @SerializedName("price")
        val price: Double,

        @SerializedName("description")
        val description: String,

        @Embedded
        @SerializedName("brand")
        val brand: Brand


) {
    fun getIdString(): String {
        return id.toString()
    }

    fun getPriceString(): String {
        return price.toString()
    }

    fun getReleaseYearString(): String {
        return releaseYear.toString()
    }


    fun getBrandTitleAndModel(): String {
        return brand.title + " " + model + " " + generation
    }

    fun getCarCardDescription(): String {
        return "$releaseYear, $mileage, $engineCapacity l, $fuelType, $transmissionType"
    }

    fun getMileageString(): String {
        return mileage.toString()
    }

    fun getEngineCapacityString():String{
        return engineCapacity.toString()
    }
}
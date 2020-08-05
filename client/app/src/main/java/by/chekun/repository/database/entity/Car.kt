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

        @SerializedName("releaseYear")
        val releaseYear: Int,

        @SerializedName("price")
        val price: Double,

        @SerializedName("description")
        val description: String,

        @Embedded
        @SerializedName("brand")
        val brand: Brand


)
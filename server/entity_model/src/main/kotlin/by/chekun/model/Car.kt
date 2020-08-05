package by.chekun.model

import javax.persistence.*

@Entity
@Table(name = "cars")
class Car : AbstractEntity {

    @Column(name = "title", nullable = false)
    lateinit var model: String

    @Column(name = "release_year")
    var releaseYear: Int = 0

    @Column(name = "price")
    var price: Double = 0.0

    @Column(name = "description", length = 512)
    lateinit var description: String

    //поколение
    //тип кузова
    //тип топлива
    //тип коробки
    //пробег
    //привод
    //цвет салона
    //материал салона
    //
    //

    @ManyToOne(fetch = FetchType.LAZY)
    lateinit var brand: Brand

    constructor()

}

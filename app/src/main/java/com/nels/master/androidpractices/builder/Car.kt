package com.nels.master.androidpractices.builder

class Car private constructor(
   val brand: String,
   val model: String,
   val year: Int,
   val color:String
){
    class Builder{

        private var brand: String = ""
        private var model: String = ""
        private var year: Int = 0
        private var color: String = ""

        //mas kotlin
        fun brand(brand: String) = apply { this.brand = brand}

        //Mas java
        fun model(model: String):Builder{
            this.model = model
            return this
        }

        //Mas java
        fun year(year: Int): Builder{
            this.year = year
            return this
        }

        //Mas java
        fun color(color: String):Builder{
            this.color = color
            return this
        }
        //Mas javab sin control de parametros
        fun build():Car{
            return Car(
                brand = brand,
                model = model,
                year = year,
                color = color
            )
        }

        //Con control de parametros
        fun build2():Car{

            require(brand.isNotBlank())
            require(model.isNotBlank())
            require(color.isNotBlank())
            require(year > 1800){"Tiene que ser mayor a 1800"}

            return Car(
                brand = brand,
                model = model,
                year = year,
                color = color
            )
        }
    }

}
import kotlin.system.exitProcess

enum class Speed(val value: String, val downLimit: Int, val upLimit: Int){
    LOW("so low speed", 1, 200),
    MID("average speed", 201, 500),
    HIGH("high speed", 501, 1000)
}


sealed interface TypeOfTransport{
    val transportClassification: String
    val speedOfTransport: Speed
}


abstract class GroundTransport(val limitSpeed: Int,
                               val fuelCapacity: Int,
                               val brand: String): TypeOfTransport{
    override val transportClassification = "ground transport"
    override val speedOfTransport = Speed.LOW
}


class Truck private constructor(limitSpeed: Int,
                                     fuelCapacity: Int,
                                     brand: String,
                                     private val liftingCapacity: Int): GroundTransport(limitSpeed, fuelCapacity, brand){
    companion object{
        fun build(): Truck{
            println("Input brand of truck")
            val b: String = readln()
            println("Input speed limit (km for hour from 1 to 200)")
            val s: Int? = readln().toIntOrNull()
            println("Input lifting capacity (kilo from 1 to 3000)")
            val l: Int? = readln().toIntOrNull()
            println("Input capacity of fuel (liters from 1 to 150)")
            val f: Int? = readln().toIntOrNull()
            return if (s == null || f == null || b.isEmpty() || l == null || b.toIntOrNull() != null || s !in 1..200 || l !in 1..3000 || f !in 1..150){
                println("************\nDo a normal input!\n************")
                Truck(-100, 0, "0", 0)
            } else{
                Truck(s, f, b, l)
            }
        }
    }
    override fun toString(): String{
        return if (limitSpeed < 0) "Corrupted value" else "\nExample of Truck:\n" +
                "brand of truck = $brand,\nspeed limit = $limitSpeed km/hour or ${speedOfTransport.value},\ncapacity of fuel = $fuelCapacity liters,\n" +
                "lifting capacity = $liftingCapacity kilo.\n"
    }
}


class Car private constructor(limitSpeed: Int,
                                     fuelCapacity: Int,
                                     brand: String,
                                     private val countOfPeople: Int): GroundTransport(limitSpeed, fuelCapacity, brand){
    companion object{
        fun build(): Car{
            println("Input brand of car")
            val b: String = readln()
            println("Input speed limit (km for hour from 1 to 200)")
            val s: Int? = readln().toIntOrNull()
            println("Input capacity of people (from 1 to 5)")
            val p: Int? = readln().toIntOrNull()
            println("Input capacity of fuel (liters from 1 to 50)")
            val f: Int? = readln().toIntOrNull()
            return if (s == null || f == null || b.isEmpty() || p == null || b.toIntOrNull() != null || s !in 1..200 || p !in 1..5 || f !in 1..150){
                println("************\nDo a normal input!\n************")
                Car(-100, 0, "0", 0)
            } else{
                Car(s, f, b, p)
            }
        }
    }
    override fun toString(): String{
        return if (limitSpeed < 0) "Corrupted value" else "\nExample of Car:\n" +
                "brand of truck = $brand,\nspeed limit = $limitSpeed km/hour or ${speedOfTransport.value},\ncapacity of fuel = $fuelCapacity liters,\n" +
                "limit count of people = $countOfPeople.\n"
    }
}


abstract class SeaTransport(val limitSpeed: Int,
                            val fuelCapacity: Int,
                            val brand: String): TypeOfTransport{
    override val transportClassification = "sea transport"
    override val speedOfTransport = Speed.MID
}


class CruiseShip private constructor(limitSpeed: Int,
                                fuelCapacity: Int,
                                brand: String,
                                private val liftingCapacity: Int,
                                private val peopleCapacity: Int): SeaTransport(limitSpeed, fuelCapacity, brand){
    companion object{
        fun build(): CruiseShip{
            println("Input brand of cruise liner")
            val b: String = readln()
            println("Input speed limit (miles for hour from 1 to 200)")
            val s: Int? = readln().toIntOrNull()
            println("Input lifting capacity (ton from 1 to 3000)")
            val l: Int? = readln().toIntOrNull()
            println("Input capacity of people (from 2 to 2500)")
            val p: Int? = readln().toIntOrNull()
            println("Input capacity of fuel (liters from 1000 to 1500)")
            val f: Int? = readln().toIntOrNull()
            return if (s == null || f == null || b.isEmpty() || l == null || b.toIntOrNull() != null || p == null || s !in 1..200 || l !in 1..3000 || f !in 1000..1500 || p !in 2..2500){
                println("************\nDo a normal input!\n************")
                CruiseShip(-100, 0, "0", 0, 0)
            } else{
                CruiseShip(s, f, b, l, p)
            }
        }
    }
    override fun toString(): String{
        return if (limitSpeed < 0) "Corrupted value" else "\nExample of CruiseShip:\n" +
                "brand of truck = $brand,\nspeed limit = $limitSpeed miles/hour or ${speedOfTransport.value},\nlimit count of people = $peopleCapacity,\ncapacity of fuel = $fuelCapacity liters,\n" +
                "lifting capacity = $liftingCapacity ton.\n"
    }
}


abstract class InnerWaterTransport: TypeOfTransport{
    override val transportClassification = "inner water transport"
    override val speedOfTransport = Speed.LOW
}


abstract class FlyingTransport(val limitSpeed: Int,
                               val fuelCapacity: Int,
                               val brand: String): TypeOfTransport{
    override val transportClassification = "flying transport"
    override val speedOfTransport = Speed.HIGH
}


class AirPlane private constructor(limitSpeed: Int,
                                     fuelCapacity: Int,
                                     brand: String,
                                     private val liftingCapacity: Int,
                                     private val peopleCapacity: Int): SeaTransport(limitSpeed, fuelCapacity, brand){
    companion object{
        fun build(): AirPlane{
            println("Input brand of plane")
            val b: String = readln()
            println("Input speed limit (km for hour from 501 to 1000)")
            val s: Int? = readln().toIntOrNull()
            println("Input lifting capacity (ton from 1 to 50)")
            val l: Int? = readln().toIntOrNull()
            println("Input capacity of people (from 2 to 150)")
            val p: Int? = readln().toIntOrNull()
            println("Input capacity of fuel (liters from 500 to 1200)")
            val f: Int? = readln().toIntOrNull()
            return if (s == null || f == null || b.isEmpty() || l == null || b.toIntOrNull() != null || p == null || s !in 501..1000 || l !in 1..50 || f !in 500..1200 || p !in 2..150){
                println("************\nDo a normal input!\n************")
                AirPlane(-100, 0, "0", 0, 0)
            } else{
                AirPlane(s, f, b, l, p)
            }
        }
    }
    override fun toString(): String{
        return if (limitSpeed < 0) "Corrupted value" else "\nExample of AirPlane:\n" +
                "brand of truck = $brand,\nspeed limit = $limitSpeed miles/hour or ${speedOfTransport.value},\ncapacity of fuel = $fuelCapacity liters,\n" +
                "lifting capacity = $liftingCapacity ton, \nlimit count of people = $peopleCapacity,\ncapacity of fuel = $fuelCapacity."
    }
}


abstract class RailwayTransport: TypeOfTransport{
    override val transportClassification = "flying transport"
    override val speedOfTransport = Speed.MID
}


fun main(){
    var state: String = ""
    val list: MutableList<String> = mutableListOf()
    println("If u want to exit, u should print \"Exit\" without brackets, when you are asked to leave\nLets start create a new example of transport")
    while (state != "exit"){
        println("Choose: truck, car, cruiseship, plane")
        val transport: String = readln()
        val exampleOfTheClass = when(transport.lowercase()){
            "truck" -> Truck.build()
            "car" -> Car.build()
            "cruiseship" -> CruiseShip.build()
            "plane" -> AirPlane.build()
            else -> "There is no such option here!"
        }
        if (exampleOfTheClass == "There is no such option here!"){
            continue
        }
        if (exampleOfTheClass.toString() != "Corrupted value"){
            list.add(exampleOfTheClass.toString())
        }
        println(exampleOfTheClass)
        println("Do u want exit?")
        state = readln().lowercase()
    }
    println("All what u create:")
    for (i in list){
        println(i)
    }
}
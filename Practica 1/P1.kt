// Pregunta 1: Determinar salario de un empleado mediante una evaluacion de desempeño
// De: Rodrigo Alonso Ruelas Lope
// Fecha de Creacion: 24/08/2024 - 9:09 am
// Ultima modificacion: 24/08/2024 - 9:49 am

fun main(args: Array<String>) {
    var Puntuacion_E : Int = 8
    var Salario_E : Double = 10000.00

    println(" -- Resultados de la evaluacion -- ")

    println("Nivel de rendimiento")
    Hallar_Nivel(Puntuacion_E)
    println("Dinero recibido")
    print(Hallar_Dinero(Puntuacion_E, Salario_E))
}

fun Hallar_Nivel(punt : Int) : Unit {
    when (punt) {
        in 0..3 -> println("Inaceptable")
        in 4..6 -> println("Aceptable")
        in 7..10 -> println("Meritorio")
        else -> println("Puntuacion no valida")
    }
}

fun Hallar_Dinero(punt : Int, sal : Double) : Unit {
    val Dinero : Double = sal * (punt/10.0)
    println(Dinero)
}

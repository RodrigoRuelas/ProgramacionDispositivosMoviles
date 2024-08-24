// Pregunta 4: Juego de adivinar un número.
// De: Rodrigo Alonso Ruelas Lope
// Fecha de Creacion: 24/08/2024 - 4:55 pm
// Ultima modificacion: 24/08/2024 - 5:20 pm

import kotlin.random.Random

fun main() {
    val numeroSecreto = generarNumeroSecreto(1, 30)
    val intentosMaximos = 5

    println("¡Bienvenido al juego de adivinar el número!")
    println("He escogido un número entre 1 y 30. Tienes $intentosMaximos intentos para adivinarlo.")

    val adivinadoCorrectamente = jugar(intentosMaximos, numeroSecreto)

    if (adivinadoCorrectamente) {
        println("¡Felicidades! ¡Has adivinado el número!")
    } else {
        println("Lo siento, se te acabaron los intentos. El número era $numeroSecreto.")
    }
}

fun generarNumeroSecreto(inicio: Int, fin: Int): Int {
    return Random.nextInt(inicio, fin + 1)
}

fun jugar(intentosMaximos: Int, numeroSecreto: Int): Boolean {
    var intentosRestantes = intentosMaximos

    while (intentosRestantes > 0) {
        val suposicion = obtenerSuposicion()

        if (suposicion == null) {
            println("Por favor, introduce un número válido.")
            continue
        }

        if (evaluarSuposicion(suposicion, numeroSecreto)) {
            return true
        }

        intentosRestantes--
        if (intentosRestantes > 0) {
            println("Te quedan $intentosRestantes intentos.")
        }
    }
    return false
}

fun obtenerSuposicion(): Int? {
    println("\nIntroduce tu suposición:")
    return readLine()?.toIntOrNull()
}

fun evaluarSuposicion(suposicion: Int, numeroSecreto: Int): Boolean {
    return when {
        suposicion < numeroSecreto -> {
            println("¡Demasiado bajo!")
            false
        }
        suposicion > numeroSecreto -> {
            println("¡Demasiado alto!")
            false
        }
        else -> true
    }
}

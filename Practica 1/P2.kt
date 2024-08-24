// Pregunta 2: Juego de Piedra-Papel-Tijera.
// De: Rodrigo Alonso Ruelas Lope
// Fecha de Creacion: 24/08/2024 - 10:30 am
// Ultima modificacion: 24/08/2024 - 11:02 am

import kotlin.random.Random

fun obtenerOpcion(opcion: Int): String {
    return when (opcion) {
        1 -> "Piedra"
        2 -> "Papel"
        3 -> "Tijera"
        else -> ""
    }
}

fun determinarGanador(jugador: Int, computadora: Int): Int {
    return when {
        jugador == computadora -> 0 // Empate
        (jugador == 1 && computadora == 3) || // Piedra vence a Tijera
                (jugador == 2 && computadora == 1) || // Papel vence a Piedra
                (jugador == 3 && computadora == 2) -> 1 // Tijera vence a Papel
        else -> -1
    }
}

fun main() {
    println("Bienvenido al juego de Piedra, Papel o Tijera!")
    println("Elige una opción:\n1. Piedra\n2. Papel\n3. Tijera")

    val jugador = readLine()?.toIntOrNull()

    if (jugador == null || jugador !in 1..3) {
        println("Opción inválida, por favor selecciona 1, 2 o 3.")
        return
    }

    val computadora = Random.nextInt(1, 4)

    println("Tú elegiste: ${obtenerOpcion(jugador)}")
    println("La computadora eligió: ${obtenerOpcion(computadora)}")

    val resultado = determinarGanador(jugador, computadora)

    when (resultado) {
        0 -> println("¡Es un empate!")
        1 -> println("¡Ganaste!")
        -1 -> println("Perdiste, la computadora gana!")
    }
}

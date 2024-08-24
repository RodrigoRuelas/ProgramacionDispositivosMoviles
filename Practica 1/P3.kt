// Pregunta 3. Implementación de una calculadora básica.
// De: Rodrigo Alonso Ruelas Lope
// Fecha de Creacion: 24/08/2024 - 04:00 pm
// Ultima modificacion: 24/08/2024 - 04:37 pm

fun main() {
    while (true) {
        println("Bienvenido a la calculadora en Kotlin!")
        println("Selecciona una operación:")
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicación")
        println("4. División")
        println("5. Salir")

        val operacion = readLine()?.toIntOrNull()

        if (operacion == 5) {
            println("Saliendo de la calculadora. ¡Adiós!")
            break
        }

        if (operacion !in 1..4) {
            println("Opción inválida. Por favor selecciona una operación válida.")
            continue
        }

        println("Ingresa el primer número:")
        val num1 = readLine()?.toDoubleOrNull()

        println("Ingresa el segundo número:")
        val num2 = readLine()?.toDoubleOrNull()

        if (num1 == null || num2 == null) {
            println("Entrada inválida. Por favor ingresa números válidos.")
            continue
        }

        val resultado = when (operacion) {
            1 -> num1 + num2
            2 -> num1 - num2
            3 -> num1 * num2
            4 -> {
                if (num2 == 0.0) {
                    println("Error: No se puede dividir por cero.")
                    continue
                } else {
                    num1 / num2
                }
            }
            else -> 0.0
        }

        println("El resultado de la operación es: $resultado\n")
    }
}

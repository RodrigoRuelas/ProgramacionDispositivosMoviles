// Pregunta 3. Implementación de una calculadora básica.
// De: Rodrigo Alonso Ruelas Lope
// Fecha de Creacion: 24/08/2024 - 04:00 pm
// Ultima modificacion: 24/08/2024 - 04:50 pm

fun main() {
    println("¡Bienvenido a la calculadora en Kotlin!")
    while (true) {
        val operacion : Int = seleccionarOperacion()

        if (operacion == 5) {
            println("Saliendo de la calculadora. ¡Adiós!")
            break
        }

        val num1 = obtenerNumero("Ingresa el primer número:")
        val num2 = obtenerNumero("Ingresa el segundo número:")

        val resultado = realizarOperacion(operacion, num1, num2)
        println("El resultado de la operación es: $resultado\n")
    }
}

fun seleccionarOperacion(): Int {
    while (true) {
        println("Selecciona una operación:")
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicación")
        println("4. División")
        println("5. Salir")

        val operacion = readLine()?.toIntOrNull()

        if (operacion != null && operacion in 1..5) {
            return operacion
        } else {
            println("Opción inválida. Por favor selecciona una operación válida.")
        }
    }
}


fun obtenerNumero(mensaje: String): Double {
    println(mensaje)
    val numero = readLine()?.toDoubleOrNull()

    if (numero == null) {
        println("Entrada inválida. Por favor ingresa un número válido.")
        return obtenerNumero(mensaje)
    }

    return numero
}

fun realizarOperacion(operacion: Int, num1: Double, num2: Double): Double {
    return when (operacion) {
        1 -> suma(num1, num2)
        2 -> resta(num1, num2)
        3 -> multiplicacion(num1, num2)
        4 -> {
            if (num2 == 0.0) {
                println("Error: No se puede dividir por cero.")
                0.0
            } else {
                division(num1, num2)
            }
        }
        else -> 0.0
    }
}

fun suma(a: Double, b: Double): Double {
    return a + b
}

fun resta(a: Double, b: Double): Double {
    return a - b
}

fun multiplicacion(a: Double, b: Double): Double {
    return a * b
}

fun division(a: Double, b: Double): Double {
    return a / b
}

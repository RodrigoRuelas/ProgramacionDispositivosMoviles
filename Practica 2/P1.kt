// Pregunta 1: Creando una cuenta bancaria
// De: Rodrigo Alonso Ruelas Lope
// Fecha de Creacion: 31/08/2024 - 6:43 pm
// Ultima modificacion: 1/09/2024 - 11:55 pm

import java.util.Scanner

class CuentaBancaria(private var saldo: Double, private var limiteRetiro: Double) {
    // Método getter para obtener el saldo
    fun getSaldo(): Double {
        return saldo
    }

    // Método setter para establecer el saldo, con validación para no permitir saldo negativo
    fun setSaldo(nuevoSaldo: Double) {
        if (nuevoSaldo >= 0) {
            saldo = nuevoSaldo
        } else {
            println("El saldo no puede ser negativo.")
        }
    }

    // Método getter para obtener el límite de retiro
    fun getLimiteRetiro(): Double {
        return limiteRetiro
    }

    // Método setter para establecer el límite de retiro, con validación para no permitir límite negativo
    fun setLimiteRetiro(nuevoLimite: Double) {
        if (nuevoLimite >= 0) {
            limiteRetiro = nuevoLimite
        } else {
            println("El límite de retiro no puede ser negativo.")
        }
    }

    // Método para realizar un retiro, teniendo en cuenta el límite de retiro y el saldo disponible
    fun retirar(monto: Double) {
        if (monto > limiteRetiro) {
            println("El monto excede el límite de retiro.")
        } else if (monto > saldo) {
            println("Saldo insuficiente para realizar el retiro.")
        } else {
            saldo -= monto
            println("Retiro realizado. Nuevo saldo: $saldo")
        }
    }

    // Método para realizar un depósito
    fun depositar(monto: Double) {
        if (monto > 0) {
            saldo += monto
            println("Depósito realizado. Nuevo saldo: $saldo")
        } else {
            println("El monto del depósito debe ser positivo.")
        }
    }

    // Método para mostrar el estado de la cuenta
    fun mostrarEstadoCuenta() {
        println("Estado de la cuenta:")
        println("Saldo: $saldo")
        println("Límite de retiro: $limiteRetiro")
    }
}  

fun main() {
    val cuenta = CuentaBancaria(1000.0, 500.0)
    val scanner = Scanner(System.`in`)

    while (true) {
        println("\n--- Menú de Cuenta Bancaria ---")
        println("1. Ver estado de la cuenta")
        println("2. Realizar un depósito")
        println("3. Realizar un retiro")
        println("4. Establecer un nuevo límite de retiro")
        println("5. Salir")
        print("Seleccione una opción: ")

        when (scanner.nextInt()) {
            1 -> cuenta.mostrarEstadoCuenta()
            2 -> {
                print("Ingrese el monto a depositar: ")
                val montoDeposito = scanner.nextDouble()
                cuenta.depositar(montoDeposito)
            }
            3 -> {
                print("Ingrese el monto a retirar: ")
                val montoRetiro = scanner.nextDouble()
                cuenta.retirar(montoRetiro)
            }
            4 -> {
                print("Ingrese el nuevo límite de retiro: ")
                val nuevoLimite = scanner.nextDouble()
                cuenta.setLimiteRetiro(nuevoLimite)
            }
            5 -> {
                println("Cerrando")
                break
            }
            else -> println("Opción no válida. Por favor, intente de nuevo.")
        }
    }

    scanner.close()
}  

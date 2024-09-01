// Pregunta 1: Creando una cuenta bancaria
// De: Rodrigo Alonso Ruelas Lope
// Fecha de Creacion: 31/08/2024 - 6:43 pm
// Ultima modificacion: 31/08/2024 - 7:00 pm

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
}  

fun main() {
    val cuenta = CuentaBancaria(1000.0, 500.0)

    // Imprimir saldo inicial
    println("Saldo inicial: ${cuenta.getSaldo()}")

    // Intentar retirar un monto mayor al límite
    cuenta.retirar(600.0)

    // Intentar retirar un monto válido
    cuenta.retirar(300.0)

    // Intentar establecer un saldo negativo
    cuenta.setSaldo(-100.0)

    // Establecer un nuevo límite de retiro y realizar un retiro
    cuenta.setLimiteRetiro(1000.0)
    cuenta.retirar(800.0)
}  

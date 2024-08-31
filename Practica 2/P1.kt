// Pregunta 1: Creando una cuenta bancaria
// De: Rodrigo Alonso Ruelas Lope
// Fecha de Creacion: 31/08/2024 - 6:43 pm
// Ultima modificacion: 31/08/2024 - 0:00 pm

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
}  

fun main() {
    val cuenta = CuentaBancaria(1000.0, 500.0)
}  

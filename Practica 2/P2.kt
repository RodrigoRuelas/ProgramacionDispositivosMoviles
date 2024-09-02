// Pregunta 2: Creando un producto con sus descuentos
// De: Rodrigo Alonso Ruelas Lope
// Fecha de Creacion: 31/08/2024 - 8:02 pm
// Ultima modificacion: 2/09/2024 - 12:08 am

import java.util.Scanner

class Producto(private var precio: Double, private var descuento: Double) {
    // Método getter para obtener el precio
    fun getPrecio(): Double {
        return precio
    }

    // Método setter para establecer el precio, con validación para no permitir precios negativos
    fun setPrecio(nuevoPrecio: Double) {
        if (nuevoPrecio >= 0) {
            precio = nuevoPrecio
        } else {
            println("El precio no puede ser negativo.")
        }
    }

    // Método getter para obtener el descuento
    fun getDescuento(): Double {
        return descuento
    }

    // Método setter para establecer el descuento, con validación para no permitir descuento negativo o mayor al 100%
    fun setDescuento(nuevoDescuento: Double) {
        if (nuevoDescuento in 0.0..100.0) {
            descuento = nuevoDescuento
        } else {
            println("El descuento debe estar entre 0% y 100%.")
        }
    }

    // Método para calcular el precio final después de aplicar el descuento
    fun calcularPrecioFinal(): Double {
        val descuentoAplicado = precio * (descuento / 100)
        return precio - descuentoAplicado
    }

    // Método para incrementar el precio en un porcentaje dado
    fun incrementarPrecio(porcentaje: Double) {
        if (porcentaje >= 0) {
            precio += precio * (porcentaje / 100)
            println("Precio incrementado en $porcentaje%. Nuevo precio: $precio")
        } else {
            println("El porcentaje no puede ser negativo.")
        }
    }

    // Método para reducir el precio en un porcentaje dado
    fun reducirPrecio(porcentaje: Double) {
        if (porcentaje >= 0) {
            precio -= precio * (porcentaje / 100)
            println("Precio reducido en $porcentaje%. Nuevo precio: $precio")
        } else {
            println("El porcentaje no puede ser negativo.")
        }
    }
}  

fun main() {
    val scanner = Scanner(System.`in`)
    val producto = Producto(150.0, 10.0)

    while (true) {
        println("\n--- Menú de Producto ---")
        println("1. Ver precio actual")
        println("2. Establecer nuevo precio")
        println("3. Establecer nuevo descuento")
        println("4. Incrementar precio")
        println("5. Reducir precio")
        println("6. Calcular precio final después de descuento")
        println("7. Salir")
        print("Seleccione una opción: ")

        when (scanner.nextInt()) {
            1 -> println("Precio actual: ${producto.getPrecio()}")
            2 -> {
                print("Ingrese el nuevo precio: ")
                val nuevoPrecio = scanner.nextDouble()
                producto.setPrecio(nuevoPrecio)
            }
            3 -> {
                print("Ingrese el nuevo descuento (%): ")
                val nuevoDescuento = scanner.nextDouble()
                producto.setDescuento(nuevoDescuento)
            }
            4 -> {
                print("Ingrese el porcentaje para incrementar el precio: ")
                val porcentajeIncremento = scanner.nextDouble()
                producto.incrementarPrecio(porcentajeIncremento)
            }
            5 -> {
                print("Ingrese el porcentaje para reducir el precio: ")
                val porcentajeReduccion = scanner.nextDouble()
                producto.reducirPrecio(porcentajeReduccion)
            }
            6 -> println("Precio final después de descuento: ${producto.calcularPrecioFinal()}")
            7 -> {
                println("Cerrando")
                break
            }
            else -> println("Opción no válida. Por favor, intente de nuevo.")
        }
    }

    scanner.close()
}  

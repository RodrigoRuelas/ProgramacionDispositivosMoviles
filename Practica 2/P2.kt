// Pregunta 2: Creando un producto con sus descuentos
// De: Rodrigo Alonso Ruelas Lope
// Fecha de Creacion: 31/08/2024 - 8:02 pm
// Ultima modificacion: 31/08/2024 - 0:00 pm

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
}  

fun main() {
    val producto = Producto(150.0, 10.0)
}  

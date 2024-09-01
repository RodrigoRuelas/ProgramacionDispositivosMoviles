// Pregunta 3: Creando un programa para determinar area y perimetro de figuras geometricas
// De: Rodrigo Alonso Ruelas Lope
// Fecha de Creacion: 31/08/2024 - 8:23 pm
// Ultima modificacion: 31/08/2024 - 8:56 pm

// Clase abstracta Shape
abstract class Shape {
    abstract val area: Double
    abstract val perimetro: Double

    abstract fun calcularArea(): Double
    abstract fun calcularPerimetro(): Double

    fun imprimirResultados() {
        println("Área: $area")
        println("Perímetro: $perimetro")
    }
}

// Subclase Cuadrado
class Cuadrado(private val lado: Double) : Shape() {
    // Indicando propiedades de la clase abstracta
    override val area: Double
        get() = calcularArea()

    override val perimetro: Double
        get() = calcularPerimetro()

    // Indicando metodos de la clase abstracta
    override fun calcularArea(): Double {
        return lado * lado
    }

    override fun calcularPerimetro(): Double {
        return 4 * lado
    }
}

// Subclase Círculo
class Circulo(private val radio: Double) : Shape() {
    // Indicando propiedades de la clase abstracta
    override val area: Double
        get() = calcularArea()

    override val perimetro: Double
        get() = calcularPerimetro()

    // Indicando metodos de la clase abstracta
    override fun calcularArea(): Double {
        return Math.PI * radio * radio
    }

    override fun calcularPerimetro(): Double {
        return 2 * Math.PI * radio
    }
}

// Subclase Rectángulo
class Rectangulo(private val largo: Double, private val ancho: Double) : Shape() {
    // Indicando propiedades de la clase abstracta
    override val area: Double
        get() = calcularArea()

    override val perimetro: Double
        get() = calcularPerimetro()

    // Indicando metodos de la clase abstracta
    override fun calcularArea(): Double {
        return largo * ancho
    }

    override fun calcularPerimetro(): Double {
        return 2 * (largo + ancho)
    }
}

fun main() {
    // Crear instancias de las subclases
    val cuadrado = Cuadrado(4.0)
    val circulo = Circulo(3.0)
    val rectangulo = Rectangulo(5.0, 3.0)

    // Imprimir resultados para Cuadrado
    println("Cuadrado:")
    cuadrado.imprimirResultados()

    // Imprimir resultados para Círculo
    println("\nCírculo:")
    circulo.imprimirResultados()

    // Imprimir resultados para Rectángulo
    println("\nRectángulo:")
    rectangulo.imprimirResultados()
}  

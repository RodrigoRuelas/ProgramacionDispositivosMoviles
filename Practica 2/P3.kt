// Pregunta 3: Creando un programa para determinar area y perimetro de figuras geometricas
// De: Rodrigo Alonso Ruelas Lope
// Fecha de Creacion: 31/08/2024 - 8:23 pm
// Ultima modificacion: 31/08/2024 - 0:00 pm

// Clase abstracta Shape
abstract class Shape {

}

// Subclase Cuadrado
class Cuadrado(private val lado: Double) : Shape() {

}

// Subclase Círculo
class Circulo(private val radio: Double) : Shape() {

}

// Subclase Rectángulo
class Rectangulo(private val largo: Double, private val ancho: Double) : Shape() {

}

fun main() {
  println("Hola mundo")
}  

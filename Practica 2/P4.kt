// Pregunta 4: Sistema de Gestion de Biblioteca
// De: Rodrigo Alonso Ruelas Lope
// Fecha de Creacion: 1/09/2024 - 10:50 pm
// Ultima modificacion: 1/08/2024 - 10:40 pm

// Clase abstracta Material
abstract class Material(
    val titulo: String,
    val autor: String,
    val anioPublicacion: Int
) {
    abstract fun mostrarDetalles()
}

// Subclase Libro
class Libro(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val genero: String,
    val numeroPaginas: Int
) : Material(titulo, autor, anioPublicacion) {

    override fun mostrarDetalles() {
        println("Título: $titulo")
        println("Autor: $autor")
        println("Año de Publicación: $anioPublicacion")
        println("Género: $genero")
        println("Número de Páginas: $numeroPaginas")
    }
}

// Subclase Revista
class Revista(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val issn: String,
    val volumen: Int,
    val numero: Int,
    val editorial: String
) : Material(titulo, autor, anioPublicacion) {

    override fun mostrarDetalles() {
        println("Título: $titulo")
        println("Autor: $autor")
        println("Año de Publicación: $anioPublicacion")
        println("ISSN: $issn")
        println("Volumen: $volumen")
        println("Número: $numero")
        println("Editorial: $editorial")
    }
}

// Data class Usuario
data class Usuario(
    val nombre: String,
    val apellido: String,
    val edad: Int
)

// Interfaz IBiblioteca
interface IBiblioteca {
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestarMaterial(usuario: Usuario, material: Material): Boolean
    fun devolverMaterial(usuario: Usuario, material: Material): Boolean
    fun mostrarMaterialesDisponibles()
    fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario)
}

// Clase Biblioteca que implementa IBiblioteca
class Biblioteca : IBiblioteca {
    private val materialesDisponibles = mutableListOf<Material>()
    private val usuarios = mutableMapOf<Usuario, MutableList<Material>>()

    override fun registrarMaterial(material: Material) {
        materialesDisponibles.add(material)
        println("Material registrado: ${material.titulo}")
    }

    override fun registrarUsuario(usuario: Usuario) {
        if (usuario !in usuarios) {
            usuarios[usuario] = mutableListOf()
            println("Usuario registrado: ${usuario.nombre} ${usuario.apellido}")
        } else {
            println("El usuario ya está registrado.")
        }
    }

    override fun prestarMaterial(usuario: Usuario, material: Material): Boolean {
        return if (material in materialesDisponibles) {
            materialesDisponibles.remove(material)
            usuarios[usuario]?.add(material)
            println("Material prestado: ${material.titulo} a ${usuario.nombre} ${usuario.apellido}")
            true
        } else {
            println("El material no está disponible.")
            false
        }
    }

    override fun devolverMaterial(usuario: Usuario, material: Material): Boolean {
        return if (usuarios[usuario]?.contains(material) == true) {
            usuarios[usuario]?.remove(material)
            materialesDisponibles.add(material)
            println("Material devuelto: ${material.titulo} por ${usuario.nombre} ${usuario.apellido}")
            true
        } else {
            println("El usuario no tiene este material en préstamo.")
            false
        }
    }

    override fun mostrarMaterialesDisponibles() {
        println("Materiales disponibles:")
        materialesDisponibles.forEach { it.mostrarDetalles() }
    }

    override fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario) {
        println("Materiales reservados por ${usuario.nombre} ${usuario.apellido}:")
        usuarios[usuario]?.forEach { it.mostrarDetalles() } ?: println("No tiene materiales reservados.")
    }
}

fun main() {
    val biblioteca = Biblioteca()

    // Crear algunos materiales
    val libro1 = Libro("1984", "George Orwell", 1949, "Distopía", 328)
    val revista1 = Revista("National Geographic", "Varios Autores", 2021, "0027-9358", 300, 12, "National Geographic Society")

    // Registrar materiales en la biblioteca
    biblioteca.registrarMaterial(libro1)
    biblioteca.registrarMaterial(revista1)

    // Crear y registrar un usuario
    val usuario1 = Usuario("Juan", "Pérez", 30)
    biblioteca.registrarUsuario(usuario1)

    // Mostrar materiales disponibles
    biblioteca.mostrarMaterialesDisponibles()

    // Prestar un material
    biblioteca.prestarMaterial(usuario1, libro1)

    // Mostrar materiales disponibles después del préstamo
    biblioteca.mostrarMaterialesDisponibles()

    // Mostrar materiales reservados por el usuario
    biblioteca.mostrarMaterialesReservadosPorUsuario(usuario1)

    // Devolver un material
    biblioteca.devolverMaterial(usuario1, libro1)

    // Mostrar materiales disponibles después de la devolución
    biblioteca.mostrarMaterialesDisponibles()

    // Mostrar materiales reservados por el usuario después de la devolución
    biblioteca.mostrarMaterialesReservadosPorUsuario(usuario1)
}

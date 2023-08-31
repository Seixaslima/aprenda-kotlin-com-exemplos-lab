enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

//Usuario
class Usuario(val nome: String, var sobrenome: String) {
    constructor(nome: String): this(nome,"")
    override fun toString(): String = "$nome $sobrenome"
    
}

//Conteudo Educacional
data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val dificuldade: Nivel = Nivel.BASICO)

//Formação - composta por varios conteudos educacionais
data class Formacao(val nome: String,var duracao: Int = 0) {
    val estudantes: MutableSet<Usuario> = mutableSetOf<Usuario>()
    val conteudos = mutableSetOf<ConteudoEducacional>()
    
    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
        this.duracao += conteudo.duracao
    }
    
    fun matricular(estudante: Usuario) {
       estudantes.add(estudante)
    }
    
    override fun toString(): String {
        var resposta = ""
        resposta += "Curso: $nome, "
        resposta += "Duracao: $duracao\n"
        resposta += "Numero de matriculados: ${estudantes.size}\n"
        resposta += "Numero de cursos: ${conteudos.size}"
        
        return resposta
    }
    
    
}

fun main() {
    val formacao1 = Formacao("Aprendendo Kotlin")
    println(formacao1)
    
    val conteudo1 = ConteudoEducacional("Funçoes kotlin")
    val conteudo2 = ConteudoEducacional("Variaveis kotlin", 120, Nivel.AVANCADO)
    println(conteudo1)
    println(conteudo2)
    
    formacao1.adicionarConteudo(conteudo1)
    formacao1.adicionarConteudo(conteudo2)
    println(formacao1)
    
    val user1 = Usuario("Andre")
    val user2 = Usuario("Mathias","Pinto")
    println(user1)
    println(user2)
    
    formacao1.matricular(user1)
    formacao1.matricular(user2)
    println(formacao1)
    
}
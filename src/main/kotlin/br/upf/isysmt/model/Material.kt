package br.upf.isysmt.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Material (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val codigo: String,
    val descricao: String,
    val preco: Double,
    val diametro: Double,
    val dataCadastro: LocalDateTime,
    @Enumerated(value = EnumType.STRING)
    val status: StatusMaterial,
)
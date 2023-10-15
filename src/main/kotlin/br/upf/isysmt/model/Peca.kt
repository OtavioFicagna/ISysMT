package br.upf.isysmt.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Peca (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val codigo: String,
    val preco: Double,
    val diametro: Double,
    val comprimento: Double,
    val dataCadastro: LocalDateTime,
    @Enumerated(value = EnumType.STRING)
    val status: StatusPeca,
    @OneToMany(mappedBy = "peca")
    val orcamentos: List<Orcamento> = listOf()
)
package br.upf.isysmt.model

import jakarta.persistence.*

@Entity
data class Orcamento(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val tempoFabricacao: Double,
    val precoTotal: Double,
    @ManyToOne
    val peca: Peca,
    @ManyToOne
    val material: Material,
    @Enumerated(value = EnumType.STRING)
    val status: StatusOrcamento,
)

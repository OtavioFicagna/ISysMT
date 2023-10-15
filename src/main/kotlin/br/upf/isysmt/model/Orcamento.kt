package br.upf.isysmt.model

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

@Entity
data class Orcamento(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val tempoFabricacao: Double,
    val precoTotal: Double,
    @ManyToOne
    @JoinColumn(name = "id_peca", referencedColumnName = "id")
    @JsonBackReference
    val peca: Peca,
    @ManyToOne
    @JoinColumn(name = "id_material", referencedColumnName = "id")
    val material: Material,
    @Enumerated(value = EnumType.STRING)
    val status: StatusOrcamento,
)

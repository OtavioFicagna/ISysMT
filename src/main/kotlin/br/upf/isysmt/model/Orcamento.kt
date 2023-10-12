package br.upf.isysmt.model

import jakarta.persistence.*

@Entity
data class Orcamento(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val tempoFabricacao: Double,
    //@ManyToOne
    //val peca: Peca,
    //@Enumerated(value = EnumType.STRING)
    //val status: StatusOrcamento,
    //@OneToMany(mappedBy = "orcamento")
    //val materiais: List<Material> = listOf(),
)

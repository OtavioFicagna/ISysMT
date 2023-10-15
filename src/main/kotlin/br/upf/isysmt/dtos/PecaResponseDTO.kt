package br.upf.isysmt.dtos

import br.upf.isysmt.model.Orcamento
import br.upf.isysmt.model.StatusPeca
import java.time.LocalDateTime

data class PecaResponseDTO(
    val id: Long? = null,
    val codigo: String,
    val preco: Double,
    val diametro: Double,
    val comprimento: Double,
    val dataCadastro: LocalDateTime,
    val status: StatusPeca,
    val orcamentos: List<Orcamento> = listOf()
)

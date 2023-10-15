package br.upf.isysmt.dtos

import br.upf.isysmt.model.Material
import br.upf.isysmt.model.Peca
import br.upf.isysmt.model.StatusOrcamento

data class OrcamentoResponseDTO (
    val id: Long? = null,
    val tempoFabricacao: Double,
    val precoTotal: Double,
    val peca: Peca,
    val material: Material,
    val status: StatusOrcamento,
)
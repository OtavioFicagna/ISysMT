package br.upf.isysmt.dtos

import br.upf.isysmt.model.Material
import br.upf.isysmt.model.Peca
import br.upf.isysmt.model.StatusOrcamento
import jakarta.validation.constraints.NotNull

data class OrcamentoDTO (
    val tempoFabricacao: Double,
    val precoTotal: Double,
    @field:NotNull(message = "Deve ser informado o codigo da peça a ser orçada")
    val peca: Peca,
    @field:NotNull(message = "Deve ser informado o codigo do material da peça a ser orçada")
    val material: Material,
    val status: StatusOrcamento,
)
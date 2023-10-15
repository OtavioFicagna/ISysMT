package br.upf.isysmt.dtos

import br.upf.isysmt.model.StatusPeca
import jakarta.validation.constraints.NotBlank
import java.time.LocalDateTime

data class PecaDTO(
    @field:NotBlank(message = "Deve ser informado o codigo da peça")
    val codigo: String,
    val preco: Double,
    val diametro: Double,
    val comprimento: Double,
    val dataCadastro: LocalDateTime,
    val status: StatusPeca,
)

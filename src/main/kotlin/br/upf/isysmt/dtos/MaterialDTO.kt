package br.upf.isysmt.dtos

import br.upf.isysmt.model.StatusMaterial
import jakarta.validation.constraints.NotBlank
import java.time.LocalDateTime

data class MaterialDTO(
    @field:NotBlank(message = "Deve ser informado o codigo do material")
    val codigo: String?,
    val preco: Double,
    @field:NotBlank(message = "Deve ser informado a descrição do material")
    val descricao: String?,
    val diametro: Double,
    val dataCadastro: LocalDateTime,
    val status: StatusMaterial,
)

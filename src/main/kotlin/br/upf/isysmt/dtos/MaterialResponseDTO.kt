package br.upf.isysmt.dtos

import br.upf.isysmt.model.StatusMaterial
import java.time.LocalDateTime

data class MaterialResponseDTO(
    val id: Long?,
    val codigo: String?,
    val preco: Double,
    val descricao: String?,
    val diametro: Double,
    val dataCadastro: LocalDateTime,
    val status: StatusMaterial,
)

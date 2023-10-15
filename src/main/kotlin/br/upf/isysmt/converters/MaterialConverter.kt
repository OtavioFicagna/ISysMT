package br.upf.isysmt.converters

import br.upf.isysmt.dtos.MaterialDTO
import br.upf.isysmt.dtos.MaterialResponseDTO
import br.upf.isysmt.model.Material
import org.springframework.stereotype.Component

@Component
class MaterialConverter {
    fun toMaterial(dto: MaterialDTO): Material {
        return Material(
            codigo = dto.codigo,
            descricao = dto.descricao,
            status = dto.status,
            preco = dto.preco,
            diametro = dto.diametro,
            dataCadastro = dto.dataCadastro,
        )
    }

    fun toMaterialResponseDTO(Material: Material): MaterialResponseDTO {
        return MaterialResponseDTO(
            id = Material.id,
            codigo = Material.codigo,
            descricao = Material.descricao,
            status = Material.status,
            preco = Material.preco,
            diametro = Material.diametro,
            dataCadastro = Material.dataCadastro,
        )
    }
}
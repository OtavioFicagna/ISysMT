package br.upf.isysmt.service

import br.upf.isysmt.converters.MaterialConverter
import br.upf.isysmt.dtos.MaterialDTO
import br.upf.isysmt.dtos.MaterialResponseDTO
import br.upf.isysmt.exceptions.NotFoundException
import br.upf.isysmt.repository.MaterialRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

private const val MATERIAL_NOT_FOUND_MESSAGE = "MATERIAL NÃO ENCONTRADO!"

@Service
class MaterialService(val repository: MaterialRepository, val converter: MaterialConverter) {
    fun listAll(id: Long?, paginacao: Pageable): Page<MaterialResponseDTO> {
        val mateiais = if (id == null) {
            repository.findAll(paginacao)
        } else {
            repository.findById(id, paginacao)
        }
        return mateiais.map(converter::toMaterialResponseDTO)
    }

    fun idSearch(id: Long): MaterialResponseDTO {
        val material = repository.findById(id)
            .orElseThrow { NotFoundException(MATERIAL_NOT_FOUND_MESSAGE) }
        return converter.toMaterialResponseDTO(material)
    }

    fun register(dto: MaterialDTO): MaterialResponseDTO {
        return converter.toMaterialResponseDTO(
            repository.save(converter.toMaterial(dto))
        )
    }

    fun update(id: Long, dto: MaterialDTO): MaterialResponseDTO {
        val material = repository.findById(id)
            .orElseThrow { NotFoundException(MATERIAL_NOT_FOUND_MESSAGE) }
            .copy(
                preco = dto.preco,
                status = dto.status,
                diametro = dto.diametro,
            )
        return converter.toMaterialResponseDTO(repository.save(material))
    }
    fun delete(id: Long) {
        repository.deleteById(id)
    }
}
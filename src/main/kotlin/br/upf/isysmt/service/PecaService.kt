package br.upf.isysmt.service

import br.upf.isysmt.converters.PecaConverter
import br.upf.isysmt.dtos.PecaDTO
import br.upf.isysmt.dtos.PecaResponseDTO
import br.upf.isysmt.exceptions.NotFoundException
import br.upf.isysmt.model.Peca
import br.upf.isysmt.repository.PecaRepository
import org.springframework.stereotype.Service

private const val PECA_NOT_FOUND_MESSAGE = "PECA NÃO ENCONTRADA!"

@Service
class PecaService(val repository: PecaRepository, val converter: PecaConverter) {
    fun listAll(): List<Peca> {
        return repository.findAll()
    }

    fun idSearch(id: Long): PecaResponseDTO {
        val peca = repository.findById(id)
            .orElseThrow { NotFoundException(PECA_NOT_FOUND_MESSAGE) }
        return converter.toPecaResponseDTO(peca)
    }

    fun register(dto: PecaDTO): PecaResponseDTO {
        return converter.toPecaResponseDTO(
            repository.save(converter.toPeca(dto))
        )
    }

    fun update(id: Long, dto: PecaDTO): PecaResponseDTO {
        val peca = repository.findById(id)
            .orElseThrow { NotFoundException(PECA_NOT_FOUND_MESSAGE) }
            .copy(
                preco = dto.preco,
                status = dto.status,
                comprimento = dto.comprimento,
                diametro = dto.diametro,
            )
        return converter.toPecaResponseDTO(repository.save(peca))
    }
    fun delete(id: Long) {
        repository.deleteById(id)
    }
}
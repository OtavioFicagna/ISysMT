package br.upf.isysmt.service

import br.upf.isysmt.converters.OrcamentoConverter
import br.upf.isysmt.dtos.OrcamentoDTO
import br.upf.isysmt.dtos.OrcamentoResponseDTO
import br.upf.isysmt.exceptions.NotFoundException
import br.upf.isysmt.model.Orcamento
import br.upf.isysmt.repository.OrcamentoRepository
import org.springframework.stereotype.Service

private const val ORCAMENTO_NOT_FOUND_MESSAGE = "ORÇAMENTO NÃO ENCONTRADO!"
@Service
class OrcamentoService(val repository: OrcamentoRepository, val converter: OrcamentoConverter) {
    fun listAll(): List<Orcamento> {
        return repository.findAll()
    }

    fun idSearch(id: Long): OrcamentoResponseDTO {
        val orcamento = repository.findById(id)
            .orElseThrow { NotFoundException(ORCAMENTO_NOT_FOUND_MESSAGE) }
        return converter.toOrcamentoResponseDTO(orcamento)
    }

    fun register(dto: OrcamentoDTO): OrcamentoResponseDTO {
        return converter.toOrcamentoResponseDTO(
            repository.save(converter.toOrcamento(dto))
        )
    }

    fun update(id: Long, dto: OrcamentoDTO): OrcamentoResponseDTO {
        val orcamento = repository.findById(id)
            .orElseThrow { NotFoundException(ORCAMENTO_NOT_FOUND_MESSAGE) }
            .copy(
                tempoFabricacao = dto.tempoFabricacao,
                status = dto.status,
                precoTotal = dto.precoTotal,
                peca = dto.peca,
                material = dto.material,
            )
        return converter.toOrcamentoResponseDTO(repository.save(orcamento))
    }
    fun delete(id: Long) {
        repository.deleteById(id)
    }

}
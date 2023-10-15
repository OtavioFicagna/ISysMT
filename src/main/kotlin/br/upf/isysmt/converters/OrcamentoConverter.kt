package br.upf.isysmt.converters

import br.upf.isysmt.dtos.OrcamentoDTO
import br.upf.isysmt.dtos.OrcamentoResponseDTO
import br.upf.isysmt.model.Orcamento
import org.springframework.stereotype.Component

@Component
class OrcamentoConverter {
    fun toOrcamento(dto: OrcamentoDTO): Orcamento {
        return Orcamento(
            tempoFabricacao = dto.tempoFabricacao,
            status = dto.status,
            precoTotal = dto.precoTotal,
            peca = dto.peca,
            material = dto.material,
        )
    }

    fun toOrcamentoResponseDTO(orcamento: Orcamento): OrcamentoResponseDTO {
        return OrcamentoResponseDTO(
            tempoFabricacao = orcamento.tempoFabricacao,
            status = orcamento.status,
            precoTotal = orcamento.precoTotal,
            peca = orcamento.peca,
            material = orcamento.material,
        )
    }
}
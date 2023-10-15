package br.upf.isysmt.converters

import br.upf.isysmt.dtos.PecaDTO
import br.upf.isysmt.dtos.PecaResponseDTO
import br.upf.isysmt.model.Peca
import org.springframework.stereotype.Component

@Component
class PecaConverter {
    fun toPeca(dto: PecaDTO): Peca {
        return Peca(
            codigo = dto.codigo,
            status = dto.status,
            preco = dto.preco,
            diametro = dto.diametro,
            comprimento = dto.comprimento,
            dataCadastro = dto.dataCadastro,
            orcamentos = listOf(),
        )
    }

    fun toPecaResponseDTO(Peca: Peca): PecaResponseDTO {
        return PecaResponseDTO(
            codigo = Peca.codigo,
            status = Peca.status,
            preco = Peca.preco,
            diametro = Peca.diametro,
            comprimento = Peca.comprimento,
            dataCadastro = Peca.dataCadastro,
            orcamentos = Peca.orcamentos,
        )
    }
}
package br.upf.isysmt.repository

import br.upf.isysmt.model.Orcamento
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrcamentoRepository: JpaRepository<Orcamento, Long> {
    fun findById(nomeOrcamento: Orcamento, paginacao: Pageable): Page<Orcamento>
}
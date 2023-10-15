package br.upf.isysmt.repository

import br.upf.isysmt.model.Peca
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PecaRepository: JpaRepository<Peca, Long> {
    fun findById(nomePeca: Peca, paginacao: Pageable): Page<Peca>
}
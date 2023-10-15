package br.upf.isysmt.repository

import br.upf.isysmt.model.Peca
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PecaRepository: JpaRepository<Peca, Long> {
}
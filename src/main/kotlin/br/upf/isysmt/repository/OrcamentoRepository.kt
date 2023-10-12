package br.upf.isysmt.repository

import br.upf.isysmt.model.Orcamento
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface OrcamentoRepository: JpaRepository<Orcamento, Long> {

}
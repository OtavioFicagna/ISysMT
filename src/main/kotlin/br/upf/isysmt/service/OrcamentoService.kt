package br.upf.isysmt.service

import br.upf.isysmt.model.Orcamento
import br.upf.isysmt.repository.OrcamentoRepository
import org.springframework.stereotype.Service

@Service
class OrcamentoService(val repository: OrcamentoRepository) {
    fun listar(): List<Orcamento> {
        return repository.findAll()
    }

}
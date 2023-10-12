package br.upf.isysmt.controller

import br.upf.isysmt.model.Orcamento
import br.upf.isysmt.service.OrcamentoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/orcamentos")
class OrcamentoController(val service: OrcamentoService) {

    @GetMapping
    fun listar(): List<Orcamento>{
        return service.listar()
    }
}
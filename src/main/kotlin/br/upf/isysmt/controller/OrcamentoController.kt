package br.upf.isysmt.controller

import br.upf.isysmt.dtos.OrcamentoDTO
import br.upf.isysmt.dtos.OrcamentoResponseDTO
import br.upf.isysmt.model.Orcamento
import br.upf.isysmt.service.OrcamentoService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/orcamentos")
class OrcamentoController(val service: OrcamentoService) {
    @GetMapping
    fun listar(@RequestParam(required = false) id: Long?, paginacao: Pageable): Page<OrcamentoResponseDTO> {
        return service.listAll(id, paginacao)
    }
    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): OrcamentoResponseDTO {
        return service.idSearch(id)
    }

    @PostMapping
    @Transactional
    fun cadastra(@RequestBody @Valid dto: OrcamentoDTO,
                 uriBuilder: UriComponentsBuilder
    ): ResponseEntity<OrcamentoResponseDTO> {
        val orcamentoResponse = service.register(dto)
        val created = uriBuilder.path("/orcamentos/${orcamentoResponse.id}")
            .build().toUri()
        return ResponseEntity.created(created).body(orcamentoResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun update(@PathVariable id: Long,
                  @RequestBody @Valid dto: OrcamentoDTO
    ): OrcamentoResponseDTO {
        return service.update(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun delete(@PathVariable id: Long) {
        service.delete(id)
    }
}
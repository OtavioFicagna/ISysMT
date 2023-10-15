package br.upf.isysmt.controller

import br.upf.isysmt.dtos.PecaDTO
import br.upf.isysmt.dtos.PecaResponseDTO
import br.upf.isysmt.service.PecaService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/pecas")
class PecaController(val service: PecaService) {
    @GetMapping
    fun listar(@RequestParam(required = false) id: Long?, paginacao: Pageable): Page<PecaResponseDTO> {
        return service.listAll(id, paginacao)
    }
    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): PecaResponseDTO {
        return service.idSearch(id)
    }

    @PostMapping
    @Transactional
    fun cadastra(@RequestBody @Valid dto: PecaDTO,
                 uriBuilder: UriComponentsBuilder
    ): ResponseEntity<PecaResponseDTO> {
        val pecaResponse = service.register(dto)
        val created = uriBuilder.path("/pecas/${pecaResponse.id}")
            .build().toUri()
        return ResponseEntity.created(created).body(pecaResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun update(@PathVariable id: Long,
               @RequestBody @Valid dto: PecaDTO
    ): PecaResponseDTO {
        return service.update(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun delete(@PathVariable id: Long) {
        service.delete(id)
    }
}
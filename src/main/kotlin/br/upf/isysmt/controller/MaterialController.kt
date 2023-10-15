package br.upf.isysmt.controller

import br.upf.isysmt.dtos.MaterialDTO
import br.upf.isysmt.dtos.MaterialResponseDTO
import br.upf.isysmt.model.Material
import br.upf.isysmt.service.MaterialService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/materiais")
class MaterialController(val service: MaterialService) {
    @GetMapping
    fun listar(): List<Material>{
        return service.listAll()
    }
    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): MaterialResponseDTO {
        return service.idSearch(id)
    }

    @PostMapping
    @Transactional
    fun cadastra(@RequestBody @Valid dto: MaterialDTO,
                 uriBuilder: UriComponentsBuilder
    ): ResponseEntity<MaterialResponseDTO> {
        val materialResponse= service.register(dto)
        val created = uriBuilder.path("/materials/${materialResponse.id}")
            .build().toUri()
        return ResponseEntity.created(created).body(materialResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun update(@PathVariable id: Long,
               @RequestBody @Valid dto: MaterialDTO
    ): MaterialResponseDTO {
        return service.update(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun delete(@PathVariable id: Long) {
        service.delete(id)
    }
}
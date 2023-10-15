package br.upf.isysmt.repository

import br.upf.isysmt.model.Material
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MaterialRepository: JpaRepository<Material, Long> {
    fun findById(id: Long, paginacao: Pageable): Page<Material>
}
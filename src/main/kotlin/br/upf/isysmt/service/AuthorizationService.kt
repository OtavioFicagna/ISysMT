package br.upf.isysmt.service

import br.upf.isysmt.repository.UsuarioRepository
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthorizationService(
    val repository: UsuarioRepository
) : UserDetailsService {

    override fun loadUserByUsername(email: String) =
        repository.findByEmail(email)

}
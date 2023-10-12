package br.upf.isysmt.exceptions

import java.lang.RuntimeException

class NotFoundException(override val message: String)
    : RuntimeException()
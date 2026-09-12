package com.superdev.helpdesk.dtos.Usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioAtualizarDto(
        @NotBlank @Size(min=2, max=60)
        String nome,

        @Size(min=6, max=255)
        String email
) {
}

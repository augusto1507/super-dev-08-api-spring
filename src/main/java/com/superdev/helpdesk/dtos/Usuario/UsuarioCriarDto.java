package com.superdev.helpdesk.dtos.Usuario;

import com.superdev.helpdesk.enums.Papel;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioCriarDto(
        @Schema(description = "Define o noe do usuário", example = "Ana da silva")
        @NotBlank @Size(min=2, max=60)
        String nome,

       @Schema(description = "Defina o email do usuário", example = "anaticket@gmail.com.br")
       @NotBlank @Email @Size(min=6,max=255)
        String email,

        @Schema(description = "Define o papel do usário: SOLICITANTE ou ATENDENTE", example = "SOLICITANTE")
        Papel papel

) {
}

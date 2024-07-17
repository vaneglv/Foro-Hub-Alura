package com.ForoHubAlura.Foro.Hub.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record AutenticarUsuario(
        @NotBlank String correo,
        @NotBlank String contrasena) {
}

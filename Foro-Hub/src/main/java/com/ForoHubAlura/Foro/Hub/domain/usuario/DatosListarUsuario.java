package com.ForoHubAlura.Foro.Hub.domain.usuario;

public record DatosListarUsuario(
        String nombre,
        String correo,
        Rol rol) {

    public DatosListarUsuario(Usuario usuario) {
        this(
                usuario.getNombre(),
                usuario.getCorreo(),
                usuario.getRol()
        );
    }
}

package com.ForoHubAlura.Foro.Hub.domain.topico.validaciones;

import com.ForoHubAlura.Foro.Hub.domain.topico.DatosTopico;
import com.ForoHubAlura.Foro.Hub.domain.usuario.UsuarioRepository;
import com.ForoHubAlura.Foro.Hub.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicoUsuario implements IValidadorDeTopicos {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void validar(DatosTopico datosTopico){
        if (!usuarioRepository.findById(datosTopico.idUsuario()).isPresent()) {
            throw new ValidacionDeIntegridad("Usuario no encontrado");
        }
    }
}

package com.ForoHubAlura.Foro.Hub.domain.respuesta.validaciones;

import com.ForoHubAlura.Foro.Hub.domain.respuesta.DatosRespuesta;
import com.ForoHubAlura.Foro.Hub.domain.usuario.UsuarioRepository;
import com.ForoHubAlura.Foro.Hub.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RespuestaUsuario implements IValidadorDeRespuestas {
    @Autowired
    UsuarioRepository usuarioRepository;

    public void validar(DatosRespuesta datosRespuesta) {
        if (!usuarioRepository.findById(datosRespuesta.idUsuario()).isPresent()) {
            throw new ValidacionDeIntegridad("Usuario no encotrado");
        }
    }
}
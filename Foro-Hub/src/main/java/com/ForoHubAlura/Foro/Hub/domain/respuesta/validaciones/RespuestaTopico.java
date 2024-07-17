package com.ForoHubAlura.Foro.Hub.domain.respuesta.validaciones;

import com.ForoHubAlura.Foro.Hub.domain.respuesta.DatosRespuesta;
import com.ForoHubAlura.Foro.Hub.domain.topico.TopicoRepository;
import com.ForoHubAlura.Foro.Hub.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RespuestaTopico implements IValidadorDeRespuestas {
    @Autowired
    TopicoRepository topicoRepository;

    public void validar(DatosRespuesta datosRespuesta) {
        if (!topicoRepository.findById(datosRespuesta.idTopico()).isPresent()) {
            throw new ValidacionDeIntegridad("topico no econtrado");
        }
    }
}

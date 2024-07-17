package com.ForoHubAlura.Foro.Hub.domain.topico.validaciones;

import com.ForoHubAlura.Foro.Hub.domain.topico.DatosTopico;
import com.ForoHubAlura.Foro.Hub.domain.topico.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicoDuplicado implements IValidadorDeTopicos {
    @Autowired
    private TopicoRepository topicoRepository;

    public void validar(DatosTopico datosTopico) {
        var topico = topicoRepository.findTopicoDuplicado(datosTopico.titulo(), datosTopico.mensaje());
        if (!topico.isEmpty()) {
            throw new ValidationException("El topico ya se encutra registrado");
        }
    }
}

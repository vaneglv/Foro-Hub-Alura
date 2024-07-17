package com.ForoHubAlura.Foro.Hub.domain.topico.validaciones;

import com.ForoHubAlura.Foro.Hub.domain.curso.CursoRepository;
import com.ForoHubAlura.Foro.Hub.domain.topico.DatosTopico;
import com.ForoHubAlura.Foro.Hub.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicoCurso implements IValidadorDeTopicos {
    @Autowired
    CursoRepository cursoRepository;

    public void validar(DatosTopico datosTopico) {
        if (!cursoRepository.findById(datosTopico.idCurso()).isPresent()) {
            throw new ValidacionDeIntegridad("Curso no encontrado");
        }
    }
}

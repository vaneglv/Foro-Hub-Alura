package com.ForoHubAlura.Foro.Hub.domain.topico;

import com.ForoHubAlura.Foro.Hub.domain.curso.Curso;
import com.ForoHubAlura.Foro.Hub.domain.curso.CursoRepository;
import com.ForoHubAlura.Foro.Hub.domain.topico.validaciones.IValidadorDeTopicos;
import com.ForoHubAlura.Foro.Hub.domain.usuario.Usuario;
import com.ForoHubAlura.Foro.Hub.domain.usuario.UsuarioRepository;
import com.ForoHubAlura.Foro.Hub.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    CursoRepository cursoRepository;
    @Autowired
    TopicoRepository topicoRepository;
    @Autowired
    List<IValidadorDeTopicos> iValidadorDeTopicos;

    public DatosListarTopico registrar(DatosTopico datosTopico) {
       iValidadorDeTopicos.forEach(v -> v.validar(datosTopico));
        Usuario usuario = usuarioRepository.getReferenceById(datosTopico.idUsuario());
        Curso curso = cursoRepository.getReferenceById(datosTopico.idCurso());
        Topico topico = new Topico(
                datosTopico.titulo(),
                datosTopico.mensaje(),
                usuario,
                curso
        );
        topicoRepository.save(topico);
        return new DatosListarTopico(topico);
    }

    public void validarTopico(Long id) {
        if (!topicoRepository.findById(id).isPresent()) {
            throw new ValidacionDeIntegridad("Topico no encontrado");
        }
    }

    public DatosListarTopico actualizar(DatosActualizarTopico datosActualizarTopico) {
        validarTopico(datosActualizarTopico.id());
        iValidadorDeTopicos.forEach(v -> v.validar(new DatosTopico(datosActualizarTopico)));
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.setTitulo(datosActualizarTopico.titulo());
        topico.setMensaje(datosActualizarTopico.mensaje());
        Usuario usuario = usuarioRepository.getReferenceById(datosActualizarTopico.idUsuario());
        topico.setUsuario(usuario);
        Curso curso = cursoRepository.getReferenceById(datosActualizarTopico.idCurso());
        topico.setCurso(curso);
        return new DatosListarTopico(topico);
    }
}

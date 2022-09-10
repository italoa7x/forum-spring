package br.com.forum.controllers;

import br.com.forum.controllers.form.TopicoForm;
import br.com.forum.dto.TopicoDto;
import br.com.forum.models.Topico;
import br.com.forum.services.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoService service;


    @GetMapping
    public List<TopicoDto> getAll(String nomeCurso) {
        TopicoDto topicoDto = new TopicoDto();

        if (nomeCurso == null) {
            return topicoDto.toDto(this.service.findAll());
        } else {
            return topicoDto.toDto(this.service.findByCursoNome(nomeCurso));
        }

    }


    @PostMapping
    public TopicoDto create(@RequestBody Topico topico) {
        TopicoDto topicoDto = new TopicoDto();
        if (topico != null) {
            TopicoForm topicoForm = new TopicoForm();
            topicoForm.setMensagem(topico.getMensagem());
            topicoForm.setTitulo(topico.getTitulo());
            topicoForm.setNomeCurso(topico.getC);
            return topicoDto.parseDto(this.service.create(topico));
        } else {
            return null;
        }
    }

}

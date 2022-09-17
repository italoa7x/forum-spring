package br.com.forum.controllers;

import br.com.forum.controllers.form.TopicoForm;
import br.com.forum.dto.DetalheTopicoDto;
import br.com.forum.dto.TopicoDto;
import br.com.forum.models.Topico;
import br.com.forum.repository.CursoRepository;
import br.com.forum.services.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoService service;

    @Autowired
    private CursoRepository cursoRepository;

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
    public ResponseEntity<TopicoDto> create(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {

        TopicoDto topicoDto = new TopicoDto();

        Topico topico = form.parseTopicoForm(cursoRepository);

        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(topicoDto.parseDto(this.service.create(topico)));

    }


    @GetMapping("/{id}")
    public ResponseEntity<DetalheTopicoDto> findById(@PathVariable("id") String id) {
         if (id != null) {
            return ResponseEntity.ok(new DetalheTopicoDto(this.service.findById(Long.parseLong(id))));
        }
        return ResponseEntity.notFound().build();
    }

}

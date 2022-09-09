package br.com.forum.forum.controllers;

import br.com.forum.forum.dto.TopicoDto;
import br.com.forum.forum.models.Topico;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicoController {

    private List<TopicoDto> topicos = new ArrayList<>();


    @GetMapping
    public List<TopicoDto> getAll() {
        return this.topicos;
    }

    @PostMapping
    public TopicoDto create(@RequestBody Topico topico) {
        topico.setId(this.topicos.size() + 1L);
        TopicoDto dto = new TopicoDto(topico);
        this.topicos.add(dto);

        return dto;

    }
}

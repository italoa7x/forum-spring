package br.com.forum.dto;

import br.com.forum.models.Topico;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TopicoDto {

    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao = LocalDateTime.now();


    public TopicoDto(Topico topico) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
    }

    public TopicoDto() {
    }


    public List<TopicoDto> toDto(List<Topico> topicos) {

        return topicos.stream().map(TopicoDto::new).collect(Collectors.toList());
    }

    public TopicoDto parseDto(Topico topico) {
        TopicoDto dto = new TopicoDto(topico);

        return dto;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}

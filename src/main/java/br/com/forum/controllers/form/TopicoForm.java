package br.com.forum.controllers.form;

import br.com.forum.models.Topico;

public class TopicoForm {
    private String titulo;
    private String mensagem;
    private String nomeCurso;

    public String getTitulo() {
        return titulo;
    }

    public TopicoForm parseTopicoForm(Topico topico) {
        TopicoForm topicoForm = new TopicoForm();
        topicoForm.setNomeCurso(topico.getCurso().getNome());
        topicoForm.setTitulo(topico.getTitulo());
        topicoForm.setMensagem(topico.getMensagem());
        return topicoForm;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }
}

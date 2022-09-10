package br.com.forum.services;

import br.com.forum.controllers.form.TopicoForm;
import br.com.forum.models.Topico;
import br.com.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository repository;


    public List<Topico> findAll() {
        return this.repository.findAll();
    }


    public List<Topico> findByCursoNome(String cursoNome) {
        return this.repository.findByCursoNome(cursoNome);
    }

    public Topico create(Topico topico) {

        return this.repository.save(topico);
    }
}

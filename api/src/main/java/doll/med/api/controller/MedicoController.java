package doll.med.api.controller;

import doll.med.api.medico.DadosCadastroMedico;
import doll.med.api.medico.DadosListagemMedicos;
import doll.med.api.medico.Medico;
import doll.med.api.medico.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;




    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedicos> listagemMedicos(@PageableDefault(size = 10, sort = "nome") Pageable pageable) {
        return repository.findAll(pageable).map(DadosListagemMedicos::new);
    }
}

package doll.med.api.controller;

import doll.med.api.paciente.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados){
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<DadosListagemPacientes> listagemPacientes(Pageable pageable){
        return repository.findAllByAtivoTrue(pageable).map(DadosListagemPacientes::new);
    }

    @Transactional
    @PutMapping
    public  void atualizarPaciente(@RequestBody @Valid DadosAtualizacaoPacientes dadosAtualizacaoPacientes){
        var medico = repository.getReferenceById(dadosAtualizacaoPacientes.id());
        medico.atualizarInformacoes(dadosAtualizacaoPacientes);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public void deletarPaciente(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }
}

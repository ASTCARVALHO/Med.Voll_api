package doll.med.api.controller;

import doll.med.api.paciente.DadosCadastroPaciente;
import doll.med.api.paciente.DadosListagemPacientes;
import doll.med.api.paciente.Paciente;
import doll.med.api.paciente.PacienteRepository;
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
        return repository.findAll(pageable).map(DadosListagemPacientes::new);
    }
}

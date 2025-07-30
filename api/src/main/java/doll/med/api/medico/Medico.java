package doll.med.api.medico;

import doll.med.api.endereco.Endereco;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;


@Entity
@Table(name = "medicos")
//@Getter lombok não esta funcionando
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;
    private String telefone;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;

    public Medico(DadosCadastroMedico dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.especialidade = dados.especialidade();
        this.crm = dados.crm();
        this.endereco = new Endereco(dados.endereco());
        this.telefone = dados.telefone();
    }

    public Medico(){

    }

    public Long getId() {
        return id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCrm() {
        return crm;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public void atualizarInformacoes(DadosAtualizacaoMedicos dadosAtualizacaoMedicos) {
        if (dadosAtualizacaoMedicos.nome() != null){
            this.nome = dadosAtualizacaoMedicos.nome();
        }
        if (dadosAtualizacaoMedicos.telefone() != null){
            this.telefone = dadosAtualizacaoMedicos.telefone();
        }
        if (dadosAtualizacaoMedicos.endereco() != null){
            this.endereco.atualizarInfomacoes(dadosAtualizacaoMedicos.endereco());
        }

    }
}

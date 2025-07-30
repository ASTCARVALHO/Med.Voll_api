package doll.med.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Embeddable
@Getter
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(){

    }

    public Endereco(DadosEndereco dadosEndereco) {
        this.logradouro = dadosEndereco.logradouro();
        this.bairro = dadosEndereco.bairro();
        this.cep = dadosEndereco.cep();
        this.uf = dadosEndereco.uf();
        this.cidade = dadosEndereco.cidade();
        this.complemento = dadosEndereco.complemento();
        this.numero = dadosEndereco.numero();
    }

    public void atualizarInfomacoes(DadosEndereco dadosEndereco) {
        if (dadosEndereco.logradouro() != null){
            this.logradouro = dadosEndereco.logradouro();
        }
        if (dadosEndereco.cep() != null){
            this.cep = dadosEndereco.cep();
        }
        if (dadosEndereco.bairro() != null){
            this.bairro = dadosEndereco.bairro();
        }
        if (dadosEndereco.uf() != null){
            this.uf = dadosEndereco.uf();
        }
        if (dadosEndereco.cidade() != null){
            this.cidade = dadosEndereco.cidade();
        }
        if (dadosEndereco.numero() != null){
            this.numero = dadosEndereco.numero();
        }
        if (dadosEndereco.complemento() != null){
            this.complemento = dadosEndereco.complemento();
        }

    }
}

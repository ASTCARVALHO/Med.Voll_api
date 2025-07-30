package doll.med.api.medico;

import doll.med.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedicos(Long id,
                                      @NotNull String nome,
                                      String telefone ,
                                      DadosEndereco endereco) {

}

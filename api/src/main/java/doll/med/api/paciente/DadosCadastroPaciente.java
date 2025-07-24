package doll.med.api.paciente;

import doll.med.api.endereco.DadosEndereco;

public record DadosCadastroPaciente(String nome, String email, String telefone, String cpf, DadosEndereco dadosEndereco) {
}

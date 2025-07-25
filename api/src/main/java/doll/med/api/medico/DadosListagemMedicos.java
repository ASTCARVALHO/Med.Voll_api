package doll.med.api.medico;

public record DadosListagemMedicos(String nome, String emal, String crm, Especialidade especialidade) {

    public DadosListagemMedicos(Medico medico){
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}

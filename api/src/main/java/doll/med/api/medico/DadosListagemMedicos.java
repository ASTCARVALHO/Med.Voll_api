package doll.med.api.medico;

public record DadosListagemMedicos(String nome, String emal, String crm, Especialidade especialidade, Long id) {

    public DadosListagemMedicos(Medico medico){
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade(), medico.getId());
    }
}

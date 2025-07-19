package loja.model.cliente;

public class PessoaFisica extends Cliente {
    private String cpf;

    public PessoaFisica(String id, String nome, String cpf) {
        super(id, nome); 
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}

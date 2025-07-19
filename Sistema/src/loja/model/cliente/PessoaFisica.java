package loja.model.cliente;

public class ClienteFisico extends Cliente {
    private String cpf;

    public ClienteFisico(String id, String nome, String cpf) {
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

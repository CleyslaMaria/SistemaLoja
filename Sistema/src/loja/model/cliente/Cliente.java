package loja.model.cliente;

public abstract class Cliente{
    private String id;
    private String nome;


    public Cliente(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }


    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    
    public void setid(String id) { 
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}


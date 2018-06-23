package java.com.skip.dao.model;

public class Cidade {

    private Long id;
    private String nome;

    public Cidade() {
    }

    public Cidade(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}

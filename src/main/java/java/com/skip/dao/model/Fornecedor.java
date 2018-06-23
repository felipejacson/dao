package java.com.skip.dao.model;

public class Fornecedor extends Cliente {

    String ramo;

    public Fornecedor() {
    }

    public Fornecedor(Long id) {
        setId(id);
    }

    public String getRamo() {
        return ramo;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }
}

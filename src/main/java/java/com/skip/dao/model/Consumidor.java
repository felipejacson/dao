package java.com.skip.dao.model;

public class Consumidor extends Cliente {

    private String email;

    public Consumidor() {
    }

    public Consumidor(Long id) {
        super.setId(id);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

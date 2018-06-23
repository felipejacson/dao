package java.com.skip.dao.consumidor;

import com.skip.dao.DAOFactory;
import com.skip.dao.model.Consumidor;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ConsumidorDAOImpl {

    private final DAOFactory dao = DAOFactory.getDAOFactory();
    private final ConsumidorDAO productDAO = dao.getConsumidorDAO();

    public List<Consumidor> select(Consumidor obj) {
        try {
            return productDAO.select(obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Optional<Consumidor> getConsumidorById(Long id) {
        try {
            return productDAO.select(new Consumidor(id)).stream().findFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public List<Consumidor> getAllConsumidors() {
        try {
            return productDAO.select(new Consumidor());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean insert(Consumidor obj) {
        try {
            return productDAO.insert(obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean update(Consumidor obj) {
        try {
            return productDAO.update(obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean delete(Long id) {
        try {
            return productDAO.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}

package java.com.skip.dao.cidade;

import com.skip.dao.DAOFactory;
import com.skip.dao.model.Cidade;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CidadeDAOImpl {

    private final DAOFactory dao = DAOFactory.getDAOFactory();
    private final CidadeDAO productDAO = dao.getCidadeDAO();

    public List<Cidade> select(Cidade obj) {
        try {
            return productDAO.select(obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Optional<Cidade> getCidadeById(Long id) {
        try {
            return productDAO.select(new Cidade(id)).stream().findFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public List<Cidade> getAllCidades() {
        try {
            return productDAO.select(new Cidade());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean insert(Cidade obj) {
        try {
            return productDAO.insert(obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean update(Cidade obj) {
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

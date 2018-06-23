package java.com.skip.dao.fornecedor;

import com.skip.dao.DAOFactory;
import com.skip.dao.model.Fornecedor;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class FornecedorDAOImpl {

    private final DAOFactory dao = DAOFactory.getDAOFactory();
    private final FornecedorDAO productDAO = dao.getFornecedorDAO();

    public List<Fornecedor> select(Fornecedor obj) {
        try {
            return productDAO.select(obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Optional<Fornecedor> getFornecedorById(Long id) {
        try {
            return productDAO.select(new Fornecedor(id)).stream().findFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public List<Fornecedor> getAllFornecedors() {
        try {
            return productDAO.select(new Fornecedor());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean insert(Fornecedor obj) {
        try {
            return productDAO.insert(obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean update(Fornecedor obj) {
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

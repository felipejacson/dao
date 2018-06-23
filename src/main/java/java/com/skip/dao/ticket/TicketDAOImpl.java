package java.com.skip.dao.ticket;

import com.skip.dao.DAOFactory;
import com.skip.dao.model.Ticket;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TicketDAOImpl {

    private final DAOFactory dao = DAOFactory.getDAOFactory();
    private final TicketDAO productDAO = dao.getTicketDAO();

    public List<Ticket> select(Ticket obj) {
        try {
            return productDAO.select(obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Optional<Ticket> getTicketById(Long id) {
        try {
            return productDAO.select(new Ticket(id)).stream().findFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public List<Ticket> getAllTickets() {
        try {
            return productDAO.select(new Ticket());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean insert(Ticket obj) {
        try {
            return productDAO.insert(obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean update(Ticket obj) {
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

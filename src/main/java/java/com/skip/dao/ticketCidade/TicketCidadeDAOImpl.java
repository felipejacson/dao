package java.com.skip.dao.ticketCidade;

import com.skip.dao.DAOFactory;
import com.skip.dao.model.Ticket;
import com.skip.dao.model.TicketCidade;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TicketCidadeDAOImpl {

    private final DAOFactory dao = DAOFactory.getDAOFactory();
    private final TicketCidadeDAO ticketDAO = dao.getTicketCidadeDAO();

    public List<TicketCidade> select(TicketCidade obj) {
        try {
            return ticketDAO.select(obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<TicketCidade> getAllTickets() {
        try {
            return ticketDAO.select(new TicketCidade());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean insert(TicketCidade obj) {
        try {
            return ticketDAO.insert(obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean update(TicketCidade obj) {
        try {
            return ticketDAO.update(obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean delete(Long id) {
        try {
            return ticketDAO.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}

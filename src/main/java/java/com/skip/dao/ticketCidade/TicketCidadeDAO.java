package java.com.skip.dao.ticketCidade;

import com.skip.dao.DefaultDAO;
import com.skip.dao.model.TicketCidade;

import java.sql.SQLException;

public interface TicketCidadeDAO extends DefaultDAO<TicketCidade> {

    public boolean delete(Long idTicket, Long idCidade) throws SQLException;

}

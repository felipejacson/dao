package java.com.skip.dao;

import com.skip.dao.cidade.CidadeDAO;
import com.skip.dao.consumidor.ConsumidorDAO;
import com.skip.dao.fornecedor.FornecedorDAO;
import com.skip.dao.ticket.TicketDAO;
import com.skip.dao.ticketCidade.TicketCidadeDAO;

import java.sql.Connection;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class DAOFactory {

    private enum Database {
        MYSQL;
    }

    final static private Database DATABASE = Database.MYSQL;

    public abstract Connection getConnection();

    public abstract CidadeDAO getCidadeDAO();

    public abstract ConsumidorDAO getConsumidorDAO();

    public abstract FornecedorDAO getFornecedorDAO();

    public abstract TicketDAO getTicketDAO();

    public abstract TicketCidadeDAO getTicketCidadeDAO();

    public static DAOFactory getDAOFactory() {
        if(DATABASE == Database.MYSQL) {
            return new MySQLDAOFactory();
        }

        return null;
    }

    public static String implode(String separator, Collection<String> filters) {
        return filters.stream().collect(Collectors.joining(separator));
    }

    public static String implode(String[] filters) {
        return Arrays.asList(filters).stream().collect(Collectors.joining(","));
    }

}

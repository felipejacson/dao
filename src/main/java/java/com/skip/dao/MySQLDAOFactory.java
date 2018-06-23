package java.com.skip.dao;

import com.skip.dao.cidade.CidadeDAO;
import com.skip.dao.cidade.MySQLCidadeDAO;
import com.skip.dao.consumidor.ConsumidorDAO;
import com.skip.dao.consumidor.MySQLConsumidorDAO;
import com.skip.dao.fornecedor.FornecedorDAO;
import com.skip.dao.fornecedor.MySQLFornecedorDAO;
import com.skip.dao.ticket.MySQLTicketDAO;
import com.skip.dao.ticket.TicketDAO;
import com.skip.dao.ticketCidade.MySQLTicketCidadeDAO;
import com.skip.dao.ticketCidade.TicketCidadeDAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLDAOFactory extends DAOFactory {

    @Override
    public CidadeDAO getCidadeDAO() {
        return new MySQLCidadeDAO();
    }

    @Override
    public ConsumidorDAO getConsumidorDAO() {
        return new MySQLConsumidorDAO();
    }

    @Override
    public FornecedorDAO getFornecedorDAO() {
        return new MySQLFornecedorDAO();
    }

    @Override
    public TicketDAO getTicketDAO() {
        return new MySQLTicketDAO();
    }

    @Override
    public TicketCidadeDAO getTicketCidadeDAO() {
        return new MySQLTicketCidadeDAO();
    }

    @Override
    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticketdb?useSSL=false&serverTimezone=America/Sao_Paulo", "admin", "admin");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

}

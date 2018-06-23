package java.com.skip.dao.ticket;

import com.skip.dao.MySQLDAOFactory;
import com.skip.dao.model.Ticket;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MySQLTicketDAO extends MySQLDAOFactory implements TicketDAO, TicketMetadata {

    @Override
    public List<Ticket> execute(String sql) throws SQLException {

        System.out.println(sql);

        List<Ticket> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Ticket c = new Ticket();

                c.setId(rs.getLong("ID"));
                c.setNome(rs.getString("NOME"));
                c.setDescricao(rs.getString("DESCRICAO"));
                c.setData(rs.getDate("DATA"));
                c.setCidadeId(rs.getLong("CIDADE_ID"));
                c.setNomeCidade(rs.getString("NOME_CIDADE"));
                c.setFornecedorId(rs.getLong("FORNECEDOR_ID"));
                c.setNomeFornecedor(rs.getString("NOME_FORNECEDOR"));

                list.add(c);
            }
            rs.close();
            rs = null;
            stmt.close();
            stmt = null;
            con.close();
            con = null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { ; }
                rs = null;
            }
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException e) { ; }
                stmt = null;
            }
            if (con != null) {
                try { con.close(); } catch (SQLException e) { ; }
                con = null;
            }
        }
        return list;
    }

    @Override
    public List<Ticket> select(Ticket obj) throws SQLException {
        StringBuilder sql = new StringBuilder();

        sql.append("select " + implode(METADADOSSELECT) + ", CIDADE.NOME NOME_CIDADE, FORNECEDOR.NOME NOME_FORNECEDOR");
        sql.append(" from " + TABLE + ", CIDADE, FORNECEDOR ");

        List<String> filters = new ArrayList<>();

        filters.add(TABLE + ".CIDADE_ID = CIDADE.ID");
        filters.add(TABLE + ".FORNECEDOR_ID = FORNECEDOR.ID");

        if(obj.getId() != null) {
            filters.add(TABLE + "." + PK[0] + " = " + obj.getId());
        }

        if(obj.getNome() != null) {
            filters.add(TABLE + ".NOME like '%" + obj.getNome() + "%'");
        }

        if(obj.getDescricao() != null) {
            filters.add(TABLE + ".DESCRICAO like '%" + obj.getDescricao() + "%'");
        }

        if(obj.getData() != null) {
            filters.add(TABLE + ".DATA = '" + obj.getData() + "'");
        }

        if(obj.getCidadeId() != null) {
            filters.add(TABLE + ".CIDADE_ID = " + obj.getCidadeId());
        }

        if(obj.getFornecedorId() != null) {
            filters.add(TABLE + ".FORNECEDOR_ID = " + obj.getFornecedorId());
        }

        sql.append( " where " + implode(" and ", filters));

        sql.append(" order by " + TABLE + "." + PK[0]);

        return execute(sql.toString());
    }

    @Override
    public boolean insert(Ticket obj) throws SQLException {
        boolean ret = false;
        Connection con = null;
        Statement stmt = null;
        StringBuilder sql = new StringBuilder();

        try {
            sql.append("insert into " + TABLE + " (" + implode(METADADOSINSERT) + ")");
            sql.append("values ('" + obj.getNome() + "'");
            sql.append(", '" + obj.getDescricao() + "'");

            DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
            sql.append(", '" + df.format(obj.getData()) + "'");
            sql.append(", " + obj.getCidadeId());
            sql.append(", " + obj.getFornecedorId() + ")");

            con = getConnection();
            stmt = con.createStatement();
            ret = stmt.executeUpdate(sql.toString()) > 0;
            stmt.close();
            stmt = null;
            con.close();
            con = null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException e) { ; }
                stmt = null;
            }
            if (con != null) {
                try { con.close(); } catch (SQLException e) { ; }
                con = null;
            }
        }

        return ret;
    }

    @Override
    public boolean update(Ticket obj) throws SQLException {
        boolean ret = false;
        if (obj.getId() != 0) {
            Connection con = null;
            Statement stmt = null;
            StringBuilder sql = new StringBuilder();

            try {
                sql.append("update " + TABLE + " set");
                sql.append(" NOME = '" + obj.getNome() + "'");
                sql.append(", DESCRICAO = '" + obj.getDescricao() + "'");

                DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
                sql.append(", DATA = '" + df.format(obj.getData()) + "'");

                sql.append(", CIDADE_ID = " + obj.getCidadeId());
                sql.append(", FORNECEDOR_ID = " + obj.getFornecedorId());

                sql.append( " where " + TABLE + "." + PK[0] + " = " + obj.getId());

                con = getConnection();
                stmt = con.createStatement();
                ret = stmt.executeUpdate(sql.toString()) > 0;
                stmt.close();
                stmt = null;
                con.close();
                con = null;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (stmt != null) {
                    try { stmt.close(); } catch (SQLException e) { ; }
                    stmt = null;
                }
                if (con != null) {
                    try { con.close(); } catch (SQLException e) { ; }
                    con = null;
                }
            }
        }
        return ret;
    }

    @Override
    public boolean delete(Long id) throws SQLException {
        boolean ret = false;
        if (id != 0) {
            Connection con = null;
            Statement stmt = null;
            StringBuilder sql = new StringBuilder();

            try {
                sql.append("delete from " + TABLE + " where " + TABLE + "." + PK[0] + " = " + id);

                con = getConnection();
                stmt = con.createStatement();
                ret = stmt.executeUpdate(sql.toString()) > 0;
                stmt.close();
                stmt = null;
                con.close();
                con = null;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (stmt != null) {
                    try { stmt.close(); } catch (SQLException e) { ; }
                    stmt = null;
                }
                if (con != null) {
                    try { con.close(); } catch (SQLException e) { ; }
                    con = null;
                }
            }
        }
        return ret;
    }

}

package java.com.skip.dao.consumidor;

import com.skip.dao.MySQLDAOFactory;
import com.skip.dao.model.Consumidor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySQLConsumidorDAO extends MySQLDAOFactory implements ConsumidorDAO, ConsumidorMetadata {

    @Override
    public List<Consumidor> execute(String sql) throws SQLException {
        List<Consumidor> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Consumidor c = new Consumidor();

                c.setId(rs.getLong("ID"));
                c.setNome(rs.getString("NOME"));
                c.setEmail(rs.getString("EMAIL"));

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
    public List<Consumidor> select(Consumidor obj) throws SQLException {
        StringBuilder sql = new StringBuilder();

        sql.append("select " + implode(METADADOSSELECT) + " from " + TABLE);

        List<String> filters = new ArrayList<>();

        if(obj.getId() != null) {
            filters.add(TABLE + "." + PK[0] + " = " + obj.getId());
        }

        if(obj.getNome() != null) {
            filters.add(TABLE + ".NOME like '%" + obj.getNome() + "%'");
        }

        if(obj.getEmail() != null) {
            filters.add(TABLE + ".EMAIL like '%" + obj.getEmail() + "%'");
        }

        if(!filters.isEmpty()) {
            sql.append( " where " + implode(" and ", filters));
        }

        sql.append(" order by " + TABLE + "." + PK[0]);

        return execute(sql.toString());
    }

    @Override
    public boolean insert(Consumidor obj) throws SQLException {
        boolean ret = false;
        Connection con = null;
        Statement stmt = null;
        StringBuilder sql = new StringBuilder();

        try {
            sql.append("insert into " + TABLE + " (" + implode(METADADOSINSERT) + ")");
            sql.append("values ('" + obj.getNome() + "'");
            sql.append(", '" + obj.getEmail() + "')");

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
    public boolean update(Consumidor obj) throws SQLException {
        boolean ret = false;
        if (obj.getId() != 0) {
            Connection con = null;
            Statement stmt = null;
            StringBuilder sql = new StringBuilder();

            try {
                sql.append("update " + TABLE + " set");
                sql.append(" NOME = '" + obj.getNome() + "'");
                sql.append(" , EMAIL = '" + obj.getEmail() + "'");
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

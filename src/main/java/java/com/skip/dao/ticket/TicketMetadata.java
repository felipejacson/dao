package java.com.skip.dao.ticket;

public interface TicketMetadata {

    public final String TABLE = "TICKET";

    public final String[] PK = { "ID" };

    public static String[] METADADOSINSERT = {
            "NOME", "DESCRICAO", "DATA", "CIDADE_ID", "FORNECEDOR_ID"
    };

    public static String[] METADADOSSELECT = {
            TABLE + ".ID",
            TABLE + ".NOME",
            TABLE + ".DESCRICAO",
            TABLE + ".DATA",
            TABLE + ".CIDADE_ID",
            TABLE + ".FORNECEDOR_ID"
    };

}
package java.com.skip.dao.ticketCidade;

public interface TicketCidadeMetadata {

    public final String TABLE = "TICKET_CIDADE";

    public final String[] PK = { "TICKET_ID", "CIDADE_ID" };

    public static String[] METADADOSINSERT = {
            "TICKET_ID", "CIDADE_ID"
    };

    public static String[] METADADOSSELECT = {
            TABLE + ".TICKET_ID",
            TABLE + ".CIDADE_ID"
    };

}
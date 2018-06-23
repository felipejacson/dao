package java.com.skip.dao.consumidor;

public interface ConsumidorMetadata {

    public final String TABLE = "CONSUMIDOR";

    public final String[] PK = { "ID", "NOME", "EMAIL" };

    public static String[] METADADOSINSERT = {
            "NOME", "EMAIL"
    };

    public static String[] METADADOSSELECT = {
            TABLE + ".ID",
            TABLE + ".NOME",
            TABLE + ".EMAIL"
    };

}

package java.com.skip.dao.cidade;

public interface CidadeMetadata {

    public final String TABLE = "CIDADE";

    public final String[] PK = { "ID" };

    public static String[] METADADOSINSERT = {
            "NOME"
    };

    public static String[] METADADOSSELECT = {
            TABLE + ".ID",
            TABLE + ".NOME"
    };

}

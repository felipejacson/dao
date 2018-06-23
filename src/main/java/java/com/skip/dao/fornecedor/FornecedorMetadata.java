package java.com.skip.dao.fornecedor;

public interface FornecedorMetadata {

    public final String TABLE = "FORNECEDOR";

    public final String[] PK = { "ID", "NOME", "RAMO" };

    public static String[] METADADOSINSERT = {
            "NOME", "RAMO"
    };

    public static String[] METADADOSSELECT = {
            TABLE + ".ID",
            TABLE + ".NOME",
            TABLE + ".RAMO"
    };

}

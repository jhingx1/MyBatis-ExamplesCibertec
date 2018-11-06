package sql;

public class SentenciasSql {
    static public final String TUTORIALES_QRY
            = "SELECT idtutorial, titulo, tipo, precio "
            + "FROM tutoriales ORDER BY titulo";
    static public final String TUTORIALES_GET
            = "SELECT idtutorial, titulo, tipo, precio FROM tutoriales "
            + "WHERE idtutorial=#{idtutorial}";
    static public final String TUTORIALES_INS
            = "INSERT INTO tutoriales(titulo, tipo, precio) "
            + "VALUES(#{titulo}, #{tipo}, #{precio})";
    static public final String TUTORIALES_UPD
            = "UPDATE tutoriales SET "
            + "titulo=#{titulo}, tipo=#{tipo}, precio=#{precio} "
            + "WHERE idtutorial=#{idtutorial}";
    static public final String TUTORIALES_DEL
            = "DELETE FROM tutoriales WHERE idtutorial IN(${ids})";
}

package mybatis.mapper;

import dto.Tutoriales;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import sql.SentenciasSql;
import org.apache.ibatis.annotations.Update;

public interface TutorialesMapper {

    @Select(SentenciasSql.TUTORIALES_QRY) //TUTORIALES_QRY
    public List<Tutoriales> tutorialesQry();

    @Select(TUTORIALES_GET)
    public Tutoriales tutorialesGet(@Param("idtutorial") Integer idtutorial);

    @Insert(TUTORIALES_INS)
    public int tutorialesIns(Tutoriales tutoriales);

    @Update(TUTORIALES_UPD)
    public int tutorialesUpd(Tutoriales tutoriales);

    @Delete(TUTORIALES_DEL)
    public int tutorialesDel(@Param("ids") String ids);
// sentecias SQL
    final String TUTORIALES_QRY
            = "SELECT idtutorial, titulo, tipo, precio "
            + "FROM tutoriales ORDER BY titulo";
    final String TUTORIALES_GET
            = "SELECT idtutorial, titulo, tipo, precio FROM tutoriales "
            + "WHERE idtutorial=#{idtutorial}";
    final String TUTORIALES_INS
            = "INSERT INTO tutoriales(titulo, tipo, precio) "
            + "VALUES(#{titulo}, #{tipo}, #{precio})";
    final String TUTORIALES_UPD
            = "UPDATE tutoriales SET "
            + "titulo=#{titulo}, tipo=#{tipo}, precio=#{precio} "
            + "WHERE idtutorial=#{idtutorial}";
    final String TUTORIALES_DEL
            = "DELETE FROM tutoriales WHERE idtutorial IN(${ids})";
}

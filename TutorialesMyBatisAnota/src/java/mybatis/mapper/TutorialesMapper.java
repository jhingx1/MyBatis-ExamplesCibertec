package mybatis.mapper;

import dto.Tutoriales;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TutorialesMapper {

    @Select(TUTORIALES_QRY)
    public List<Tutoriales> tutorialesQry();

    @Select(TUTORIALES_GET)
    public Tutoriales tutorialesGet(@Param("idtutorial") Integer idtutorial);

    @Insert(TUTORIALES_INS)
    @Options(useGeneratedKeys = true, keyProperty = "idtutorial")
    public int tutorialesIns(Tutoriales tutoriales);

    @Update(TUTORIALES_UPD)
    public int tutorialesUpd(Tutoriales tutoriales);

    @Delete(TUTORIALES_DEL)
    public int tutorialesDel(@Param("ids") String ids);
    
     public String getMessage();
// sentecias SQl
    String TUTORIALES_QRY
            = "SELECT idtutorial, titulo, tipo, precio "
            + "FROM tutoriales ORDER BY titulo";
    String TUTORIALES_GET
            = "SELECT idtutorial, titulo, tipo, precio FROM tutoriales "
            + "WHERE idtutorial=#{idtutorial}";
    String TUTORIALES_INS
            = "INSERT INTO tutoriales(titulo, tipo, precio) "
            + "VALUES(#{titulo}, #{tipo}, #{precio})";
    String TUTORIALES_UPD
            = "UPDATE tutoriales SET "
            + "titulo=#{titulo}, tipo=#{tipo}, precio=#{precio} "
            + "WHERE idtutorial=#{idtutorial}";
    String TUTORIALES_DEL
            = "DELETE FROM tutoriales WHERE idtutorial IN(${ids})";
}

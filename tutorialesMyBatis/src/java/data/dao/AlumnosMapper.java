package data.dao;

import data.model.Alumnos;
import dto.Tutoriales;
import java.util.List;
import org.apache.ibatis.annotations.Select;
import sql.SentenciasSql;

public interface AlumnosMapper {
    
    @Select(ALUMNOS_QRY) //TUTORIALES_QRY
    public List<Alumnos> alumnosQry();
    
    int deleteByPrimaryKey(Integer idalumno);

    int insert(Alumnos record);

    int insertSelective(Alumnos record);

    Alumnos selectByPrimaryKey(Integer idalumno);

    int updateByPrimaryKeySelective(Alumnos record);

    int updateByPrimaryKey(Alumnos record);
    
    final String ALUMNOS_QRY
            = "SELECT idalumno,nombre "
            + "FROM alumnos order by idalumno";
}
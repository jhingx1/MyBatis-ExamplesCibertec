package mybatis.mapper;

import dto.Notas;
import dto.DataSp;
import java.util.List;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

public interface NotasMapper {

    @Select("{CALL sp_query}")
    @Options(statementType = StatementType.CALLABLE)
    public List<Notas> query();
// ---

    @Select("{CALL sp_get(#{idalumno, jdbcType=INTEGER})}")
    @Options(statementType = StatementType.CALLABLE)
    public Notas get(@Param("idalumno") Integer idalumno);
// ---

    @Insert("{CALL sp_insert("
            + "#{alumno, jdbcType=VARCHAR},"
            + "#{nota1, jdbcType=SMALLINT},"
            + "#{nota2, jdbcType=SMALLINT},"
            + "#{nota3, jdbcType=SMALLINT},"
            + "#{comentario, jdbcType=VARCHAR}"
            + ")}")
    @Options(statementType = StatementType.CALLABLE)
    public int insert(Notas alumno);
// ---

    @Update("{CALL sp_update("
            + "#{idalumno, jdbcType=INTEGER},"
            + "#{alumno, jdbcType=VARCHAR},"
            + "#{nota1, jdbcType=SMALLINT},"
            + "#{nota2, jdbcType=SMALLINT},"
            + "#{nota3, jdbcType=SMALLINT},"
            + "#{comentario, jdbcType=VARCHAR}"
            + ")}")
    @Options(statementType = StatementType.CALLABLE)
    public int update(Notas alumno);
// ---

    @Delete("{CALL sp_delete(#{idalumno, jdbcType=INTEGER})}")
    @Options(statementType = StatementType.CALLABLE)
    public int delete(@Param("idalumno") Integer idalumno);
// ---

    @Select("{CALL sp_promedio("
            + "#{idalumno, mode=IN, jdbcType=INTEGER},"
            + "#{nombre, mode=OUT, jdbcType=VARCHAR},"
            + "#{promedio, mode=OUT, jdbcType=DOUBLE}"
            + ")}")
    @Options(statementType = StatementType.CALLABLE)
    public void promedio(DataSp dataSp);

}

package data.dao;

import data.model.Cursos;

public interface CursosMapper {
    int deleteByPrimaryKey(Integer idcursos);

    int insert(Cursos record);

    int insertSelective(Cursos record);

    Cursos selectByPrimaryKey(Integer idcursos);

    int updateByPrimaryKeySelective(Cursos record);

    int updateByPrimaryKey(Cursos record);
}
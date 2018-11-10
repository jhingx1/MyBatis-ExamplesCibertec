package data.dao;

import data.model.Profesores;

public interface ProfesoresMapper {
    int deleteByPrimaryKey(Integer idprofesores);

    int insert(Profesores record);

    int insertSelective(Profesores record);

    Profesores selectByPrimaryKey(Integer idprofesores);

    int updateByPrimaryKeySelective(Profesores record);

    int updateByPrimaryKey(Profesores record);
}
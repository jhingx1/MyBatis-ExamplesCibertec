package data.dao;

import data.model.Alumnos;

public interface AlumnosMapper {
    int deleteByPrimaryKey(Integer idalumno);

    int insert(Alumnos record);

    int insertSelective(Alumnos record);

    Alumnos selectByPrimaryKey(Integer idalumno);

    int updateByPrimaryKeySelective(Alumnos record);

    int updateByPrimaryKey(Alumnos record);
}
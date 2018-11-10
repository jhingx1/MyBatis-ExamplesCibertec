package data.dao;

import data.model.Departamentos;

public interface DepartamentosMapper {
    int deleteByPrimaryKey(Integer iddepartamento);

    int insert(Departamentos record);

    int insertSelective(Departamentos record);

    Departamentos selectByPrimaryKey(Integer iddepartamento);

    int updateByPrimaryKeySelective(Departamentos record);

    int updateByPrimaryKey(Departamentos record);
}
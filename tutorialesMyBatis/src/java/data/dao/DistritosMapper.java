package data.dao;

import data.model.Distritos;

public interface DistritosMapper {
    int deleteByPrimaryKey(Integer iddistrito);

    int insert(Distritos record);

    int insertSelective(Distritos record);

    Distritos selectByPrimaryKey(Integer iddistrito);

    int updateByPrimaryKeySelective(Distritos record);

    int updateByPrimaryKey(Distritos record);
}
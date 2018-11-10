package data.dao;

import data.model.Notas;

public interface NotasMapper {
    int deleteByPrimaryKey(Integer idnota);

    int insert(Notas record);

    int insertSelective(Notas record);

    Notas selectByPrimaryKey(Integer idnota);

    int updateByPrimaryKeySelective(Notas record);

    int updateByPrimaryKey(Notas record);
}
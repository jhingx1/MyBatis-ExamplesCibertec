package data.dao;

import data.model.Autores;

public interface AutoresMapper {
    int deleteByPrimaryKey(Integer idautor);

    int insert(Autores record);

    int insertSelective(Autores record);

    Autores selectByPrimaryKey(Integer idautor);

    int updateByPrimaryKeySelective(Autores record);

    int updateByPrimaryKey(Autores record);
}
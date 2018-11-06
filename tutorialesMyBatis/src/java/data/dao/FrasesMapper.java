package data.dao;

import data.model.Frases;

public interface FrasesMapper {
    int deleteByPrimaryKey(Integer idfrase);

    int insert(Frases record);

    int insertSelective(Frases record);

    Frases selectByPrimaryKey(Integer idfrase);

    int updateByPrimaryKeySelective(Frases record);

    int updateByPrimaryKeyWithBLOBs(Frases record);

    int updateByPrimaryKey(Frases record);
}
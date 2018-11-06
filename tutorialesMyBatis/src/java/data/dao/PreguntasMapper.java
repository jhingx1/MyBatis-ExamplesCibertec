package data.dao;

import data.model.Preguntas;

public interface PreguntasMapper {
    int deleteByPrimaryKey(Integer idpregunta);

    int insert(Preguntas record);

    int insertSelective(Preguntas record);

    Preguntas selectByPrimaryKey(Integer idpregunta);

    int updateByPrimaryKeySelective(Preguntas record);

    int updateByPrimaryKeyWithBLOBs(Preguntas record);

    int updateByPrimaryKey(Preguntas record);
}
package data.dao;

import data.model.Examenes;

public interface ExamenesMapper {
    int deleteByPrimaryKey(Integer idexamen);

    int insert(Examenes record);

    int insertSelective(Examenes record);

    Examenes selectByPrimaryKey(Integer idexamen);

    int updateByPrimaryKeySelective(Examenes record);

    int updateByPrimaryKeyWithBLOBs(Examenes record);

    int updateByPrimaryKey(Examenes record);
}
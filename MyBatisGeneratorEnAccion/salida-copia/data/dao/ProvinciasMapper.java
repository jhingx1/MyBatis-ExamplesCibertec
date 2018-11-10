package data.dao;

import data.model.Provincias;

public interface ProvinciasMapper {
    int deleteByPrimaryKey(Integer idprovincia);

    int insert(Provincias record);

    int insertSelective(Provincias record);

    Provincias selectByPrimaryKey(Integer idprovincia);

    int updateByPrimaryKeySelective(Provincias record);

    int updateByPrimaryKey(Provincias record);
}
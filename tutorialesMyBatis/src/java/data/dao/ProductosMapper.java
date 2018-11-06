package data.dao;

import data.model.Productos;

public interface ProductosMapper {
    int deleteByPrimaryKey(Integer idproducto);

    int insert(Productos record);

    int insertSelective(Productos record);

    Productos selectByPrimaryKey(Integer idproducto);

    int updateByPrimaryKeySelective(Productos record);

    int updateByPrimaryKey(Productos record);
}
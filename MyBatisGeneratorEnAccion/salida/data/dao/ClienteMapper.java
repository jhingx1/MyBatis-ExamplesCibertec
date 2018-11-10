package data.dao;

import data.model.Cliente;

public interface ClienteMapper {
    int deleteByPrimaryKey(Integer codigo);

    int insert(Cliente record);

    int insertSelective(Cliente record);

    Cliente selectByPrimaryKey(Integer codigo);

    int updateByPrimaryKeySelective(Cliente record);

    int updateByPrimaryKey(Cliente record);
}
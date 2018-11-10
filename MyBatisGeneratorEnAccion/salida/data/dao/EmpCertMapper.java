package data.dao;

import data.model.EmpCert;
import org.apache.ibatis.annotations.Param;

public interface EmpCertMapper {
    int deleteByPrimaryKey(@Param("employee_id") Integer employee_id, @Param("certificate_id") Integer certificate_id);

    int insert(EmpCert record);

    int insertSelective(EmpCert record);
}
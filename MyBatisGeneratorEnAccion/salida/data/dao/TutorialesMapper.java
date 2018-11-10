package data.dao;

import data.model.Tutoriales;

public interface TutorialesMapper {
    int deleteByPrimaryKey(Integer idtutorial);

    int insert(Tutoriales record);

    int insertSelective(Tutoriales record);

    Tutoriales selectByPrimaryKey(Integer idtutorial);

    int updateByPrimaryKeySelective(Tutoriales record);

    int updateByPrimaryKey(Tutoriales record);
}
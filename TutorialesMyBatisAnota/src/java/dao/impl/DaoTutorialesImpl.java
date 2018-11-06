package dao.impl;

import dto.Tutoriales;
import java.util.List;
import mybatis.SessionFactory;
import mybatis.mapper.TutorialesMapper;
import org.apache.ibatis.session.SqlSession;

public class DaoTutorialesImpl implements TutorialesMapper {

    private final SqlSession session;
    private final TutorialesMapper mapper;
    private String message;

    public DaoTutorialesImpl() {
        session = SessionFactory.getSqlSessionFactory().openSession();
        mapper = session.getMapper(TutorialesMapper.class);
    }

    @Override
    public List<Tutoriales> tutorialesQry() {

        List<Tutoriales> list = null;

        try {
            list = mapper.tutorialesQry();
        } catch (Exception e) {
            message = e.getMessage();
        }
        return list;

    }

    @Override
    public Tutoriales tutorialesGet(Integer idtutorial) {

        Tutoriales tutoriales = null;

        try {

            tutoriales = mapper.tutorialesGet(idtutorial);
            session.close();

            if (tutoriales == null) {
                throw new Exception("ID: " + idtutorial + " no existe");
            }

        } catch (Exception e) {
            session.rollback();
            message = e.getMessage();
        }
        return tutoriales;
    }

    @Override
    public int tutorialesIns(Tutoriales tutoriales) {

        try {
            int ctos = mapper.tutorialesIns(tutoriales);
            if (ctos == 0) {
                throw new Exception("0 filas afectadas");
            }
            session.commit();
        } catch (Exception e) {
            session.rollback();
            message = e.getMessage();
        }

        return 1;
    }

    @Override
    public int tutorialesUpd(Tutoriales tutoriales) {
        int ctos = 0;
        try {
            ctos = mapper.tutorialesUpd(tutoriales);
            if (ctos == 0) {
                throw new Exception("0 filas afectadas");
            }
            session.commit();
        } catch (Exception e) {
            session.rollback();
            message = e.getMessage();
        }
        
        if(ctos == 0){
            return 0;
        }else{
            return 1;
        }
        
    }

    @Override
    public int tutorialesDel(String ids) {

        try {
            int ctos = mapper.tutorialesDel(ids);
            if (ctos == 0) {
                throw new Exception("0 filas afectadas");
            }
            session.commit();
        } catch (Exception e) {
            session.rollback();
            message = e.getMessage();
        }

        return 0;
    }

    @Override
    public String getMessage() {
        return message;
    }

}

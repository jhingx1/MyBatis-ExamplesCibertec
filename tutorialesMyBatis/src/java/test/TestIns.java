package test;

import dto.Tutoriales;
import mybatis.SessionFactory;
import mybatis.mapper.TutorialesMapper;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

public class TestIns {

    public static void main(String[] args) {
        Tutoriales p1 = new Tutoriales();
        Tutoriales p2 = new Tutoriales();
        p1.setTitulo("aaa");
        p1.setTipo("Separata");
        p1.setPrecio(12D);
        p2.setTitulo("bbb");
        p2.setTipo("Video");
        p2.setPrecio(15d);
//
        SqlSession session = SessionFactory.getSqlSessionFactory().openSession();
        TutorialesMapper mapper = session.getMapper(TutorialesMapper.class);
        try {
            mapper.tutorialesIns(p1);
            mapper.tutorialesIns(p2);
            session.commit();
            System.out.println("operacion exitosa...");
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
            session.rollback();
        }
    }
}

package test;

import dto.Tutoriales;
import mybatis.SessionFactory;
import mybatis.mapper.TutorialesMapper;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

public class TutorialesGet {

    public static void main(String[] args) {

        Tutoriales p1 = new Tutoriales();
        p1.setIdtutorial(3);

        SqlSession session = SessionFactory.getSqlSessionFactory().openSession();
        TutorialesMapper mapper = session.getMapper(TutorialesMapper.class);
        try {
            mapper.tutorialesGet(p1.getIdtutorial());

            session.commit();
            System.out.println("operacion exitosa...");

            System.out.println(p1.getIdtutorial());
            System.out.println(p1.getTipo());
            System.out.println(p1.getPrecio());
            System.out.println(p1.getTitulo());

        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
            session.rollback();
        }

    }
}

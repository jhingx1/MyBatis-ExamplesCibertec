package test;

import dto.Tutoriales;
import mybatis.SessionFactory;
import mybatis.mapper.TutorialesMapper;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

public class TutorialesUpd {

    public static void main(String[] args) {
        
        Tutoriales p1 = new Tutoriales();
        p1.setIdtutorial(3);
        
        SqlSession session = SessionFactory.getSqlSessionFactory().openSession();
        TutorialesMapper mapper = session.getMapper(TutorialesMapper.class);
        try {
            
            mapper.tutorialesGet(p1.getIdtutorial());
            
            p1.setPrecio(20.4);
            p1.setTipo("xxxxxxxx");
            p1.setTitulo("Demo");
            
            mapper.tutorialesUpd(p1);            
            
            session.commit();
            System.out.println("operacion exitosa...");
            
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
            session.rollback();
        }
    }
}

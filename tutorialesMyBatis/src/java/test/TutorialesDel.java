package test;

import dto.Tutoriales;
import java.util.ArrayList;
import java.util.List;
import mybatis.SessionFactory;
import mybatis.mapper.TutorialesMapper;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

public class TutorialesDel {

    public static void main(String[] args) {
        List<Tutoriales> list = new ArrayList<>();
        Tutoriales p1 = new Tutoriales();
        p1.setIdtutorial(7);
        
        list.add(p1);
        
        SqlSession session = SessionFactory.getSqlSessionFactory().openSession();
        TutorialesMapper mapper = session.getMapper(TutorialesMapper.class);
        try {
            
            String id = "";
            for(Tutoriales tds:list){
                id = tds.getIdtutorial().toString();
                mapper.tutorialesDel(id);
            }
            
            session.commit();
            System.out.println("operacion exitosa...");
            
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
            session.rollback();
        }
    }
}

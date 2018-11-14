package test;

import dto.Tutoriales;
import mybatis.SessionFactory;
import mybatis.mapper.TutorialesMapper;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

public class Demora {
    
    public static void main(String[] args) {
        
        SqlSession session = SessionFactory.getSqlSessionFactory().openSession();
        TutorialesMapper mapper = session.getMapper(TutorialesMapper.class);

        try {
            long ini = System.currentTimeMillis();
            for (int i = 0; i < 1_000; i++) {
                
                Tutoriales tutoriales = new Tutoriales();
                tutoriales.setTitulo(String.format("titulo_%04d", i));
                tutoriales.setTipo("Video");
                tutoriales.setPrecio(20d);
                
                mapper.tutorialesIns(tutoriales);
            }
            session.commit();
            
            long fin = System.currentTimeMillis();
            System.out.println("duración: " + (fin - ini) + " ms.");
            
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
            session.rollback();
        }
    }
}

/*
Ejecutar cada ves que se inserta para borrar los registros insertados.
SELECT * FROM tutoriales
DELETE FROM tutoriales WHERE titulo LIKE '%titulo%'
*/
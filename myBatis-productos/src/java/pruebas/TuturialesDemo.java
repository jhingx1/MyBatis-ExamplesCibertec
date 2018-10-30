package pruebas;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dto.Tutoriales;

public class TuturialesDemo {

    public static void main(String args[]) throws IOException {

        Reader reader = Resources.getResourceAsReader("mybatis/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        try (SqlSession session = sqlSessionFactory.openSession()){            
            //Create a new student object            
            Tutoriales tutoriales = new Tutoriales("Tutorial 1", "Demostracion", 12.5);

            //Insert student data      
            session.insert("dto.Tutoriales.insert", tutoriales);

            System.out.println("Inserccion Satisfactoria");
            session.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
